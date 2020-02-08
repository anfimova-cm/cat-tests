package cat_tests.appmanager;

import org.openqa.selenium.chrome.ChromeDriver;

public class MarketEntityHelper extends HelperBase {

    public MarketEntityHelper(ChromeDriver driver) {
        super(driver);
    }

    public void openMarketEntityPage() {
        click(getCategoryPage().target_page_locator);
    }

    public void saveMarketEntityChanges() {
        click(getMarketEntityPage().save_changes_locator);
    }

}
