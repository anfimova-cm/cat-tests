package cat_tests.appmanager;

import org.openqa.selenium.chrome.ChromeDriver;

public class TargetingHelper extends HelperBase {

    public TargetingHelper(ChromeDriver driver) {
        super(driver);
    }

    public void setShowNever() {
        click(getMarketEntityPage().show_never_locator);
    }
}
