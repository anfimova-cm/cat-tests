package cat_tests.tests;

import cat_tests.model.TestBase;
import org.testng.annotations.Test;

public class RenameCategoryTest extends TestBase {

    @Test
    public void renameCategoryTest() {
        app.gotoCouponsPage();
        app.gotoCategorySettings("coupon_Тест");
        app.renameCategory("Test Renamed");
        app.gotoCouponsPage();
        // assert
    }

}
