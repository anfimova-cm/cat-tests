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

//    private Categories categoryCache = null;

    public String rename(String renameTo) {
        type(getCategoryPage().title_input_locator, renameTo);
        click(getCategoryPage().save_changes_locator);
        //category.withTitle(renameTo);
        return renameTo;
    }

    public void settings(CategoryData category) {
        List<WebElement> names = driver.findElements(getCategoryPage().title_locator);
        for (int i=0; i<names.size(); i++) {
            if (names.get(i).getText().equalsIgnoreCase(category.getTitle())) {
                List<WebElement> settings = driver.findElements(getCategoryPage().settings_locator);
                settings.get(i).click();
                break;
            }
        }
    }

    public void createCategory(CategoryData category) {
    }

    public int getCategoryCount() {
        return driver.findElements(getCategoryPage().title_locator).size();
    }

//    public Categories all() {
//        if (categoryCache != null) {
//            return new Categories(categoryCache);
//        }
//        categoryCache = new Categories();
//        List<WebElement> elements = driver.findElements(getCategoryPage().title_locator);
//        for (WebElement element : elements) {
//            String name = element.getText();
//            categoryCache.add(new CategoryData().withTitle(name));
//        }
//        return new Categories(categoryCache);
//    }

    public List<CategoryData> list() {
        List<CategoryData> categories = new ArrayList<>();
        List<WebElement> elements = driver.findElements(getCategoryPage().title_locator);
        for (WebElement element : elements) {
            String name = element.getText();
            CategoryData category = new CategoryData(name);
            categories.add(category);
        }
        return categories;
    }

    public String searchRenamed(CategoryData category) {
        List<WebElement> names = driver.findElements(getCategoryPage().title_locator);
        String name = null;
        for (WebElement element : names) {
            if (element.getText().equalsIgnoreCase(category.getTitle())) {
                name = element.getText();
                break;
            }
        }
        return name;
    }
}