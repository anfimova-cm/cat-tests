package cat_tests.tests;

import cat_tests.model.Categories;
import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CategoryTests extends TestBase {

    @DataProvider(name = "dataCategoryTests")
    public Iterator<Object[]> dataProviderMethod() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {
                // Временно секция без секции
                new SectionData().withTitle("Без секции"),
                new CategoryData()
        });
        return list.iterator();
    }

    @Test(enabled = true, dataProvider = "dataCategoryTests")
    public void createCategoryTest(SectionData section, CategoryData category) {
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

    @Test(enabled = true, dataProvider = "dataCategoryTests")
    public void renameCategoryTest(SectionData section, CategoryData category) {
        // TODO: проверка наличия категории, если нет - создание
        category.withTitle("TestCategory");
        String testTitle = "TestCategoryRenamed";

        app.section().open(section);
        Categories before = app.category().set();
        app.category().rename(category, testTitle);

        app.goTo().catalog();
        app.section().open(section);
        Categories after = app.category().set();
        assertThat(before.size(), equalTo(after.size()));
        assertThat(before.without(category), equalTo(after.without(category)));
        assertThat(category.getTitle(), equalTo(testTitle));
    }

    @Test(enabled = true, dataProvider = "dataCategoryTests")
    public void deleteCategoryTest(SectionData section, CategoryData category) {
        category.withTitle("TestCategoryRenamed");

        app.section().open(section);
        Categories before = app.category().set();
        app.category().delete(category);

        app.goTo().catalog();
        app.section().open(section);
        Categories after = app.category().set();
        assertThat(before.size(), equalTo(after.size() + 1));
        assertThat(before.without(category), equalTo(after));
    }
}
