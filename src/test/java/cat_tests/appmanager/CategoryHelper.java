package cat_tests.appmanager;

import cat_tests.model.Categories;
import cat_tests.model.CategoryData;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CategoryHelper extends HelperBase {

    public CategoryHelper(Selenide driver) {
        super(driver);
    }

    private Categories categoryCache = null;

    public Categories set() {
        if (categoryCache != null) {
            return new Categories(categoryCache);
        }
        categoryCache = new Categories();
        if ($$(getCategoryPage().title).size() == 0) {
            // TODO: names.size() = 0, если без sleep
            sleep(2000);
        }
        List<SelenideElement> names = $$(getCategoryPage().title);
        // TODO: как использовать не index?
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i).getText();
            String uid = $$(getCategoryPage().uid).get(i).getText();
            CategoryData category = new CategoryData().withUid(uid).withTitle(name);
            categoryCache.add(category);
        }
        return new Categories(categoryCache);
    }

    public void settings(CategoryData category) {
        List<SelenideElement> names = $$(getCategoryPage().title);
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).getText().equalsIgnoreCase(category.getTitle())) {
                click($$(getCategoryPage().settings).get(i));
            }
        }
    }

    public void create(CategoryData category) {
        String title = category.getTitle();
        click(getCategoryPage().add_category);
        type(getCategoryPage().title_input, title);
        click(getCategoryPage().create_button);
        // TODO: без sleep не тот урл
        sleep(2000);
        String url = WebDriverRunner.url();
        // TODO: покрасивее сделать
        List<String> splittedUrls = Arrays.asList(url.split("/"));
        String uid = splittedUrls.get(splittedUrls.size() - 1);
        category.withUid(uid).withTitle(title);
        categoryCache = null;
    }

    public void rename(CategoryData category, String title) {
        settings(category);
        type(getCategoryPage().title_input, title);
        click(getCategoryPage().save_changes);
        category.withTitle(title);
        categoryCache = null;
    }

    public void delete(CategoryData category) {
        settings(category);
        click(getCategoryPage().delete_button);
        categoryCache = null;
    }

}