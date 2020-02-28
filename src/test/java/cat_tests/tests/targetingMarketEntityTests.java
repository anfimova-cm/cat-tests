package cat_tests.tests;

import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import cat_tests.model.ShowcaseData;
import org.testng.annotations.Test;

public class targetingMarketEntityTests extends TestBase {

    @Test (enabled = false)
    public void setRestrictionsTest() {

        SectionData section = new SectionData().withTitle("�����");
        CategoryData category = new CategoryData().withTitle("RMC");
        ShowcaseData showcase = new ShowcaseData().withTitle("������� �����");

        app.section().open(section);
        //app.category().showCategory(category);
        app.getShowcaseHelper().select(showcase);
        app.getMarketEntityHelper().openPage();
        app.getTargetingHelper().setShowNever();
        app.getMarketEntityHelper().saveChanges();
    }



}
