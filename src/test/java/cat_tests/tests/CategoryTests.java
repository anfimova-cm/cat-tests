package cat_tests.tests;

import org.testng.annotations.Test;

public class CategoryTests extends TestBase {

    @Test
    public void renameCategoryTest() {
        app.getNavigationHelper().gotoSection("������");
        app.getCategoryHelper().gotoCategorySettings("Test");
        app.getCategoryHelper().renameCategory("Test Renamed");
        app.getNavigationHelper().gotoSection("������");
        // assert
    }

}
