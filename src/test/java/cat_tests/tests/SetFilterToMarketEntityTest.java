package cat_tests.tests;

import org.testng.annotations.Test;

public class SetFilterToMarketEntityTest extends TestBase {

    @Test
    public void setFilterTest() {
        app.getNavigationHelper().gotoSection("Карты");
        app.getCategoryHelper().showCategory("RMC");
        app.getShowcaseHelper().selectShowcase("Золотой телец");
        app.getMarketEntityHelper().openMarketEntityPage();
        app.getTargetingHelper().setShowNever();
        app.getMarketEntityHelper().saveMarketEntityChanges();
    }



}
