package cat_tests.tests;

import org.testng.annotations.Test;

public class SetFilterToMarketEntityTest extends TestBase {

    @Test
    public void setFilterTest() {
        app.getNavigationHelper().gotoSection("�����");
        app.getCategoryHelper().showCategory("RMC");
        app.getShowcaseHelper().selectShowcase("������� �����");
        app.getMarketEntityHelper().openMarketEntityPage();
        app.getTargetingHelper().setShowNever();
        app.getMarketEntityHelper().saveMarketEntityChanges();
    }



}
