package cat_tests.appmanager;

import cat_tests.model.Categories;
import cat_tests.model.CategoryData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class CategoryHelper extends HelperBase {

    public CategoryHelper(ChromeDriver driver) {
        super(driver);
    }

    private Categories categoryCache = null;

    public CategoryData rename(CategoryData category, String renameTo) {
        type(getCategoryPage().title_input_locator, renameTo);
        click(getCategoryPage().save_changes_locator);
        // categoryCache = null;
        category.setName(renameTo);
        return category;
    }

    public void settings(CategoryData category) {
        List<WebElement> names = driver.findElements(getCategoryPage().title_locator);
        for (int i=0; i<names.size(); i++) {
            if (names.get(i).getText().equalsIgnoreCase(category.getName())) {
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

    public Categories all() {
        if (categoryCache != null) {
            return new Categories(categoryCache);
        }
        categoryCache = new Categories();
        List<WebElement> elements = driver.findElements(getCategoryPage().title_locator);
        for (WebElement element : elements) {
            String name = element.getText();
            categoryCache.add(new CategoryData().setName(name));
        }
        return new Categories(categoryCache);
    }

    public List<CategoryData> list() {
        List<CategoryData> categories = new ArrayList<>();
        List<WebElement> elements = driver.findElements(getCategoryPage().title_locator);
        for (WebElement element : elements) {
            String name = element.getText();
            CategoryData category = new CategoryData().setName(name);
            categories.add(category);
        }
        return categories;
    }

    public String searchRenamed(CategoryData category) {
        List<WebElement> names = driver.findElements(getCategoryPage().title_locator);
        String name = "";
        for (WebElement element : names) {
            if (element.getText().equalsIgnoreCase(category.getName())) {
                name = element.getText();
                break;
            }
        }
        return name;
    }
}