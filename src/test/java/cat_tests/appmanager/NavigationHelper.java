package cat_tests.appmanager;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(Selenide driver) {
        super(driver);
    }

    public void catalog() {
        click(getMainPage().catalog_page);
    }

    public void crumbCatalog() {
        click(getMainPage().bread_crumb_catalog);
    }
}