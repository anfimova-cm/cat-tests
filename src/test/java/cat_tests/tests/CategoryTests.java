package cat_tests.tests;

import cat_tests.model.Categories;
import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CategoryTests extends TestBase {

    @DataProvider


    @BeforeMethod
    public void ensurePreconditions() {
    // TODO: проверка наличия категории, если нет - создание
    }

    @Test (enabled = false)
    public void createCategoryTest() {

    }

    @Test (enabled = true)
    public void renameCategoryTest() {

        SectionData section = new SectionData().setName("Скидки");
        CategoryData category = new CategoryData().setName("Test");
        final String name = category.getName();
        final String testName = "Test Renamed";

        app.goTo().openSection(section);
        Categories beforeAll = app.category().all();
        app.category().settings(category);
        app.category().rename(category, testName);

        // Проверка
        app.goTo().openSection(section);
        Categories afterRename = app.category().all();
        assertThat(beforeAll.size(), equalTo(afterRename.size()));

        // Категория с новым именем есть в списке категорий
        assertThat(app.category().searchRenamed(category), equalTo(testName));

        // Переименование обратно
        app.category().settings(category);
        app.category().rename(category, name);
        category.setName(name);

        // Проверка, что всё осталось как было до переименования
        app.goTo().openSection(section);
        Categories afterAll = app.category().all();
        assertThat(beforeAll.size(), equalTo(afterAll.size()));
        assertThat(beforeAll, equalTo(afterAll));
    }

    @Test (enabled = false)
    public void deleteCategoryTest() {

    }

}
