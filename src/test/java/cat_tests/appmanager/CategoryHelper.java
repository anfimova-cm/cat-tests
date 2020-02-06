package cat_tests.appmanager;

import cat_tests.model.CategoryData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class CategoryHelper extends HelperBase {

    public CategoryHelper(ChromeDriver driver) {
        super(driver);
    }

    public void renameCategory(String renameTo) {
        type(categoryPage.header_locator, renameTo);
        click(categoryPage.save_changes_locator);
    }

    public void gotoCategorySettings(CategoryData category) {
        List<WebElement> names = driver.findElements(categoryPage.name_locator);
        for (int i=0; i<names.size(); i++) {
            if (names.get(i).getText().equalsIgnoreCase(category.getName())) {
                List<WebElement> settings = driver.findElements(categoryPage.settings_locator);
                settings.get(i).click();
                break;
            }
        }
    }

    public void showCategory(CategoryData category) {
    }

    public void createCategory(CategoryData category) {
    }

    public int getCategoryCount() {
        return driver.findElements(categoryPage.name_locator).size();
    }

    public List<CategoryData> getCategoryList() {
        List<CategoryData> categories = new ArrayList<>();
        List<WebElement> elements = driver.findElements(categoryPage.name_locator);
        for (WebElement element : elements) {
            String name = element.getText();
            CategoryData category = new CategoryData(name);
            categories.add(category);
        }
        return categories;
    }
}