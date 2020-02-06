package cat_tests.tests;

import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import org.testng.annotations.Test;

public class SetFilterToMarketEntityDataTests extends TestBase {

    @Test
    public void setFilterTest() {

        SectionData section = new SectionData("Карты");
        CategoryData category = new CategoryData("RMC");

        app.getNavigationHelper().gotoSection(section);
        app.getCategoryHelper().showCategory(category);
        app.getShowcaseHelper().selectShowcase("Золотой телец");
        app.getMarketEntityHelper().openMarketEntityPage();
        app.getTargetingHelper().setShowNever();
        app.getMarketEntityHelper().saveMarketEntityChanges();
    }



}
