package cat_tests.appmanager;

import cat_tests.model.SectionData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ChromeDriver driver) {
        super(driver);
    }

    public void catalog() {
        click(getMainPage().catalog_page_locator);
    }
}