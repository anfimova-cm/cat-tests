package cat_tests.tests;

import cat_tests.model.Categories;
import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CategoryTests extends TestBase {

    @DataProvider(name = "dataCategoryTests")
    public Object[][] dataProviderMethod() {
        return new Object[0][0];
    }

    @Test(enabled = true, priority = 0, dataProvider = "dataCategoryTests")
    public void createCategoryTest() {

        // Временно секция без секции
        SectionData section = new SectionData().withTitle("Без секции");
        CategoryData category = new CategoryData();
        String title = "TestCategory";

        app.section().open(section);
        Categories before = app.category().set();
        app.category().create(category, title);
        app.goTo().catalog();
        app.section().open(section);
        Categories after = app.category().set();
        assertThat(before.size(), equalTo(after.size() - 1));
        assertThat(before.with(category), equalTo(after));

    }

    @Test(enabled = true, priority = 1, dataProvider = "dataCategoryTests")
    public void renameCategoryTest() {

        // TODO: проверка наличия категории, если нет - создание

        SectionData section = new SectionData().withTitle("Без секции");
        CategoryData category = new CategoryData().withTitle("TestCategory");
        final String testTitle = "TestCategoryRenamed";

        app.section().open(section);
        Categories before = app.category().set();
        app.category().settings(category);
        app.category().rename(category, testTitle);

        app.goTo().catalog();
        app.section().open(section);
        Categories after = app.category().set();
        assertThat(before.size(), equalTo(after.size()));
        assertThat(before.without(category), equalTo(after.without(category)));
        assertThat(category.getTitle(), equalTo(testTitle));

        // Переименование обратно
//        app.category().settings(category);
//        app.category().rename(category, title);

        // Проверка, что всё осталось как было до переименования
//        app.goTo().catalog();
//        app.section().open(section);
//        Set<CategoryData> afterAll = app.category().set();
//        assertThat(before.size(), equalTo(afterAll.size()));
//        assertThat(before, equalTo(afterAll));

    }

    @Test(enabled = true, priority = 2, dataProvider = "dataCategoryTests")
    public void deleteCategoryTest() {

        SectionData section = new SectionData().withTitle("Без секции");
        CategoryData category = new CategoryData().withTitle("TestCategoryRenamed");

        app.section().open(section);
        Categories before = app.category().set();
        app.category().settings(category);
        app.category().delete(category);

        app.goTo().catalog();
        app.section().open(section);
        Categories after = app.category().set();
        assertThat(before.size(), equalTo(after.size() + 1));
        assertThat(before.without(category), equalTo(after));

    }
}
