package cat_tests.tests;

import cat_tests.model.TestBase;
import org.testng.annotations.Test;

public class SetFilterToMarketEntityTest extends TestBase {

    @Test
    public void setFilterTest() {
        app.gotoDiscountPage();
        app.showAllCategory("RMC");
        app.selectShowcase("������� �����");
        app.openMarketEntityPage();
        app.setShowNever();
        app.saveChanges();
    }



}
