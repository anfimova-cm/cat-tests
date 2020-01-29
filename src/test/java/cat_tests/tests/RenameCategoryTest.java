package cat_tests.tests;

import org.testng.annotations.Test;

public class RenameCategoryTest extends TestBase {

    @Test
    public void renameCategoryTest() {
        app.getNavigationHelper().gotoSection("Скидки");
        app.getCategoryHelper().gotoCategorySettings("coupon_Тест");
        app.getCategoryHelper().renameCategory("Test Renamed");
        app.getNavigationHelper().gotoSection("Скидки");
        // assert
    }

}
