package cat_tests.tests;

import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CategoryTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

    }

    @Test
    public void renameCategoryTest() {

        // TODO: проверка наличия категории, если нет - создание

        SectionData section = new SectionData("Скидки");

        CategoryData category = new CategoryData("Test");
        final String name = category.getName();
        final String toName = "Test Renamed";

        app.goTo().openSection(section);
        List<CategoryData> beforeAll = app.category().list();
        app.category().settings(category);
        app.category().rename(toName);
        category.setName(toName);

        // Проверка
        app.goTo().openSection(section);
        List<CategoryData> afterRename = app.category().list();
        Assert.assertEquals(beforeAll.size(), afterRename.size());

        // Категория с новым именем есть в списке категорий
        Assert.assertEquals(app.category().searchRenamedCategory(category), toName);
        assertThat(app.category().searchRenamedCategory(category), equalTo(toName));

        // Переименование обратно
        app.category().settings(category);
        app.category().rename(name);
        category.setName(name);

        // Проверка, что всё осталось как было до переименования
        app.goTo().openSection(section);
        List<CategoryData> afterAll = app.category().list();
        Assert.assertEquals(beforeAll.size(), afterAll.size());
        Assert.assertEquals(beforeAll, afterAll);

    }

}
