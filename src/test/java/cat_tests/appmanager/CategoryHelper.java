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

    public Categories set() {
        if (categoryCache != null) {
            return new Categories(categoryCache);
        }
        categoryCache = new Categories();
        // TODO: как использовать foreach, а не index?
        List<WebElement> names = driver.findElements(getCategoryPage().title_locator);
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i).getText();
            String uid = driver.findElements(getCategoryPage().uid_locator).get(i).getText();
            CategoryData category = new CategoryData().withUid(uid).withTitle(name);
            categoryCache.add(category);
        }
        return new Categories(categoryCache);
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
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).getText().equalsIgnoreCase(category.getTitle())) {
                click(driver.findElements(getCategoryPage().settings_locator).get(i));
            }
        }
    }

    public void create(CategoryData category) {
        String title = category.getTitle();
        click(getCategoryPage().add_category_locator);
        type(getCategoryPage().title_input_locator, title);
        click(getCategoryPage().create_button_locator);
        category.withTitle(title);
        categoryCache = null;
    }

    public void rename(CategoryData category, String title) {
        settings(category);
        type(getCategoryPage().title_input_locator, title);
        click(getCategoryPage().save_changes_locator);
        category.withTitle(title);
        categoryCache = null;
    }

    public void delete(CategoryData category) {
        settings(category);
        click(getCategoryPage().delete_button_locator);
        categoryCache = null;
    }

}