package cat_tests.tests;

import cat_tests.model.TestBase;
import org.testng.annotations.Test;

public class RenameCategoryTest extends TestBase {

    @Test
    public void renameCategoryTest() {
        app.getNavigationHelper().gotoCouponsCategory();
        app.getCategoryHelper().gotoCategorySettings("coupon_Тест");
        app.getCategoryHelper().renameCategory("Test Renamed");
        app.getNavigationHelper().gotoCouponsCategory();
        // assert
    }

}
