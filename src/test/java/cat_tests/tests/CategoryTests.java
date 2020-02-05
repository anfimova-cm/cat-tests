package cat_tests.tests;

import cat_tests.model.CategoryData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CategoryTests extends TestBase {

    @Test
    public void renameCategoryTest() {

        // проверка, если нет - создание

        app.getNavigationHelper().gotoSection("Скидки");
        List<CategoryData> before = app.getCategoryHelper().getCategoryList();

        app.getCategoryHelper().gotoCategorySettings(new CategoryData("Test"));
        app.getCategoryHelper().renameCategory("Test Renamed");
        app.getNavigationHelper().gotoSection("Скидки");

        List<CategoryData> after = app.getCategoryHelper().getCategoryList();
        Assert.assertEquals(before.size(), after.size());

        // assert новое имя = желаемое
        // переименовать обратно

        // Сравнивать HashSet - неупорядоченные
        // Assert.assertNotEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Assert.assertNotEquals(before, after);

    }

}
