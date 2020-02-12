package cat_tests.appmanager;

import cat_tests.model.SectionData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SectionHelper extends HelperBase {

    public SectionHelper(ChromeDriver driver) {
        super(driver);
    }

    public void open(SectionData section) {
        click(getSectionPage().main_menu_locator);
        List<WebElement> names = driver.findElements(getSectionPage().title_in_menu_locator);
        for (int i=0; i < names.size(); i++) {
            if (names.get(i).getText().equalsIgnoreCase(section.getTitle())) {
                click(names.get(i));
                break;
            }
        }
    }

}
