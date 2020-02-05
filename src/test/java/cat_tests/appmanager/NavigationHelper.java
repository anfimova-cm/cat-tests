package cat_tests.appmanager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ChromeDriver driver) {
        super(driver);
    }

    public void gotoCatalogPage() {
        click(catalog_main_page_locator);
    }

    public void openSectionMenu() {
        click(section_menu_locator);
    }

    public void gotoSection(String sectionName) {
        gotoCatalogPage();
        openSectionMenu();
        List<WebElement> list = driver.findElements(section_name_locator);
            for (int i=0; i<list.size(); i++) {
                String name = list.get(i).getText();
                if (name.equalsIgnoreCase(sectionName)) {
                    list.get(i).click();
                    break;
                }
            }
    }

}