package cat_tests.tests;

import org.testng.annotations.Test;

public class RenameCategoryTest extends TestBase {

    @Test
    public void renameCategoryTest() {
        app.getNavigationHelper().gotoSection("������");
        app.getCategoryHelper().gotoCategorySettings("coupon_����");
        app.getCategoryHelper().renameCategory("Test Renamed");
        app.getNavigationHelper().gotoSection("������");
        // assert
    }

}
