package cat_tests.tests;

import cat_tests.appmanager.HelperBase;
import org.testng.annotations.Test;

public class CategoryTests extends TestBase {

    @Test
    public void renameCategoryTest() {
        app.getNavigationHelper().gotoSection("Скидки");
        app.getCategoryHelper().gotoCategorySettings("Test");
        app.getCategoryHelper().renameCategory("Test Renamed");
        app.getNavigationHelper().gotoSection("Скидки");
        // assert
    }

}
