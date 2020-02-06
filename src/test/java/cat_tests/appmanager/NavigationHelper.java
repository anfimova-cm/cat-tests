package cat_tests.appmanager;

import cat_tests.model.SectionData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ChromeDriver driver) {
        super(driver);
    }

    public void gotoCatalogPage() {
        click(getMainPage().catalog_main_page_locator);
    }

    public void openSectionMenu() {
        click(getSectionPage().main_menu_locator);
    }

    public void gotoSection(SectionData section) {
        gotoCatalogPage();
        openSectionMenu();
        List<WebElement> names = driver.findElements(getSectionPage().name_locator);
        for (WebElement name : names) {
            if (name.getText().equalsIgnoreCase(section.getName())) {
                name.click();
                break;
            }
        }
    }

}