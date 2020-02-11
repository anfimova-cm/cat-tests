package cat_tests.appmanager;

import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ChromeDriver driver) {
        super(driver);
    }

    public void catalog() {
        click(getMainPage().catalog_page_locator);
    }

    public void crumbCatalog() {
        click(getMainPage().bread_crumb_catalog_locator);
    }
}