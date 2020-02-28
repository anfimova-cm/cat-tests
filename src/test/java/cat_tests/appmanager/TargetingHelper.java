package cat_tests.appmanager;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TargetingHelper extends HelperBase {

    public TargetingHelper(Selenide driver) {
        super(driver);
    }

    public void setShowNever() {
        click(getMarketEntityPage().show_never);
    }
}
