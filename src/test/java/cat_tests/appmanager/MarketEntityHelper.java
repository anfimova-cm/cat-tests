package cat_tests.appmanager;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MarketEntityHelper extends HelperBase {

    public MarketEntityHelper(Selenide driver) {
        super(driver);
    }

    public void openPage() {
        click(getCategoryPage().target_page);
    }

    public void saveChanges() {
        click(getMarketEntityPage().save_changes);
    }

}
