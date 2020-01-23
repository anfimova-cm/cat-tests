package cat_tests.tests;

import cat_tests.model.TestBase;
import org.testng.annotations.Test;

public class SetFilterToMarketEntityTest extends TestBase {

    @Test
    public void setFilterTest() {
        app.getCategoryNavigationHelper().gotoDiscountCategory();
        app.showAllCategory("RMC");
        app.selectShowcase("Золотой телец");
        app.openMarketEntityPage();
        app.setShowNever();
        app.saveMarketEntityChanges();
    }



}
