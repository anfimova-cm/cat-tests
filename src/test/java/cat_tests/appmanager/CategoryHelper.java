package cat_tests.appmanager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CategoryHelper extends HelperBase {

    public CategoryHelper(ChromeDriver driver) {
        super(driver);
    }

    public void renameCategory(String renameTo) {
        type(category_header_locator, renameTo);
        click(save_category_changes_locator);
    }

    public void gotoCategorySettings(String categoryName) {
        List<WebElement> names = driver.findElements(category_name_locator);
        for (int i=0; i<names.size(); i++) {
            String name = names.get(i).getText();
            if (name.equalsIgnoreCase(categoryName)) {
                List<WebElement> settings = driver.findElements(category_settings_locator);
                settings.get(i).click();
                break;
            }
        }
    }

    public void showCategory(String categoryName) {

    }

    public void createCategory(String categoryName) {
        // TODO
    }
}