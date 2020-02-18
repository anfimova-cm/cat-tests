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

    public int getCategoryCount() {
        return driver.findElements(getCategoryPage().title_locator).size();
    }

    public Categories set() {
        Categories categories = new Categories();
        List<WebElement> elements = driver.findElements(getCategoryPage().title_locator);
        for (WebElement element : elements) {
            String name = element.getText();
            CategoryData category = new CategoryData().withTitle(name);
            categories.add(category);
        }
        return categories;
    }

    public List<CategoryData> list() {
        List<CategoryData> categories = new ArrayList<>();
        List<WebElement> elements = driver.findElements(getCategoryPage().title_locator);
        for (WebElement element : elements) {
            String name = element.getText();
            CategoryData category = new CategoryData().withTitle(name);
            categories.add(category);
        }
        return categories;
    }

    public void settings(CategoryData category) {
        List<WebElement> names = driver.findElements(getCategoryPage().title_locator);
        for (int i=0; i < names.size(); i++) {
            if (names.get(i).getText().equalsIgnoreCase(category.getTitle())) {
                List<WebElement> settings = driver.findElements(getCategoryPage().settings_locator);
                WebElement element = settings.get(i);
                click(element);
                break;
            }
        }
    }

    public void create(CategoryData category, String title) {
        click(getCategoryPage().add_category_locator);
        type(getCategoryPage().title_input_locator, title);
        click(getCategoryPage().create_button_locator);
        category.withTitle(title);
    }

    public void rename(CategoryData category, String renameTo) {
        type(getCategoryPage().title_input_locator, renameTo);
        click(getCategoryPage().save_changes_locator);
        category.withTitle(renameTo);
    }

    public void delete(CategoryData category) {
        click(getCategoryPage().delete_button_locator);
    }

}