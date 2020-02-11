package cat_tests.tests;

import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import cat_tests.model.ShowcaseData;
import org.testng.annotations.Test;

public class targetingMarketEntityTests extends TestBase {

    @Test (enabled = false)
    public void setRestrictionsTest() {

        SectionData section = new SectionData().withTitle("Карты");
        CategoryData category = new CategoryData().withTitle("RMC");
        ShowcaseData showcase = new ShowcaseData().setTitle("Золотой телец");

        app.section().open(section);
        //app.category().showCategory(category);
        app.getShowcaseHelper().selectShowcase(showcase);
        app.getMarketEntityHelper().openMarketEntityPage();
        app.getTargetingHelper().setShowNever();
        app.getMarketEntityHelper().saveMarketEntityChanges();
    }



}
