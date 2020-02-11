package cat_tests.pages;

import org.openqa.selenium.By;

public class CategoryPage {

    public final By title_locator =
            By.xpath(".//div[contains(@class, 'CategoryTitleContainer')]");
    public final By uid_locator =
            By.xpath(".//");
    public final By add_category_locator =
            By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[contains(@href, 'plus')][1]");
    public final By show_all_locator =
            By.xpath(".//div[contains(@class, 'category-folding-card')]//*[text()='Показать все']");
    public final By settings_locator =
            By.xpath(".//div[contains(@class, 'category-folding-card')]//*[contains(@href, 'gear')]");
    public final By title_input_locator =
            By.xpath(".//label[contains(@class, 'text-field')]//div[text()='Заголовок']/../input");
    public final By save_changes_locator =
            By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[text()='Сохранить изменения']");
    public final By create_button_locator =
            By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[text()='Создать']");
    public final By target_page_locator = By.linkText("Перейти");

}
