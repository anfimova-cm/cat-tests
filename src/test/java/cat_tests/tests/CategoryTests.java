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
        final String name = category.getName();
        final String rename = "Test Renamed";

        app.getNavigationHelper().gotoSection(section);
        List<CategoryData> beforeAll = app.getCategoryHelper().getCategoryList();
        app.getCategoryHelper().gotoCategorySettings(category);
        app.getCategoryHelper().renameCategory(rename);
        category.setName(rename);

        // Проверка
        app.getNavigationHelper().gotoSection(section);
        List<CategoryData> afterRename = app.getCategoryHelper().getCategoryList();
        Assert.assertEquals(beforeAll.size(), afterRename.size());

        // Категория с новым именем есть в списке категорий
        Assert.assertEquals(app.getCategoryHelper().searchRenamedCategory(category), rename);

        // Переименование обратно
        app.getCategoryHelper().gotoCategorySettings(category);
        app.getCategoryHelper().renameCategory(name);
        category.setName(name);

        // Проверка, что всё осталось как было до переименования
        app.getNavigationHelper().gotoSection(section);
        List<CategoryData> afterAll = app.getCategoryHelper().getCategoryList();
        Assert.assertEquals(beforeAll.size(), afterAll.size());
        Assert.assertEquals(beforeAll, afterAll);

    }

}
