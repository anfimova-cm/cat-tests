package cat_tests.tests;

import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CategoryTests extends TestBase {

    @Test
    public void renameCategoryTest() {

        // TODO: проверка наличия категории, если нет - создание

        SectionData section = new SectionData("Скидки");

        CategoryData category = new CategoryData("Test");
        final String name = category.getTitle();
        final String rename = "Test Renamed";

        app.section().open(section);
        List<CategoryData> beforeAll = app.category().list();
        app.category().settings(category);
        app.category().rename(rename);
        category.setTitle(rename);

        // Проверка
        app.goTo().catalog();
        app.section().open(section);
        List<CategoryData> afterRename = app.category().list();
        Assert.assertEquals(beforeAll.size(), afterRename.size());
        // TODO: Проверить, что новое имя есть в списке и = желаемое
        // А просто что не равны

        Assert.assertNotEquals(beforeAll, afterRename);

        // Переименование обратно
        app.category().settings(category);
        app.category().rename(name);
        category.setTitle(name);

        // Проверка, что всё осталось как было до переименования
        app.goTo().catalog();
        app.section().open(section);
        List<CategoryData> afterAll = app.category().list();
        Assert.assertEquals(beforeAll.size(), afterAll.size());
        Assert.assertEquals(beforeAll, afterAll);

    }

}
