package cat_tests.appmanager;

import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ChromeDriver driver) {
        super(driver);
    }

    public void catalog() {
        click(getMainPage().catalog_page_locator);
    }
}