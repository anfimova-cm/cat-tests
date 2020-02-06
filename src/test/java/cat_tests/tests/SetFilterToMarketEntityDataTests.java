package cat_tests.tests;

import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import cat_tests.model.ShowcaseData;
import org.testng.annotations.Test;

public class SetFilterToMarketEntityDataTests extends TestBase {

    @Test
    public void setFilterTest() {

        SectionData section = new SectionData("Карты");
        CategoryData category = new CategoryData("RMC");
        ShowcaseData showcase = new ShowcaseData("Золотой телец");

        app.getNavigationHelper().gotoSection(section);
        app.getCategoryHelper().showCategory(category);
        app.getShowcaseHelper().selectShowcase(showcase);
        app.getMarketEntityHelper().openMarketEntityPage();
        app.getTargetingHelper().setShowNever();
        app.getMarketEntityHelper().saveMarketEntityChanges();
    }



}
