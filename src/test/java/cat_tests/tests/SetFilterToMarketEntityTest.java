package cat_tests.tests;

import cat_tests.model.TestBase;
import org.testng.annotations.Test;

public class SetFilterToMarketEntityTest extends TestBase {

    @Test
    public void setFilterTest() {
        app.getNavigationHelper().gotoDiscountCategory();
        app.getCategoryHelper().showAllCategory("RMC");
        app.getShowcaseHelper().selectShowcase("Золотой телец");
        app.getMarketEntityHelper().openMarketEntityPage();
        app.getTargetingHelper().setShowNever();
        app.getMarketEntityHelper().saveMarketEntityChanges();
    }



}
