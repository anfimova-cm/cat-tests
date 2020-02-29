package cat_tests.appmanager;

import com.codeborne.selenide.Selenide;

public class TargetingHelper extends HelperBase {

    public TargetingHelper(Selenide driver) {
        super(driver);
    }

    public void setShowNever() {
        click(getMarketEntityPage().show_never);
    }
}
