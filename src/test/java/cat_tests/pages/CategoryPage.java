package cat_tests.pages;

import org.openqa.selenium.By;

public class CategoryPage {

    public final By name_locator =
            By.xpath(".//div[contains(@class, 'CategoryTitleContainer')]");
    public final By show_all_locator =
            By.xpath(".//div[contains(@class, 'category-folding-card')]//*[text()='Показать все']");
    public final By settings_locator =
            By.xpath(".//div[contains(@class, 'category-folding-card')]//*[contains(@href, 'gear')]");
    public final By header_locator =
            By.xpath(".//label[contains(@class, 'text-field')]//div[text()='Заголовок']/../input");
    public final By save_changes_locator =
            By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[text()='Сохранить изменения']");
    public final By open_me_page_locator = By.linkText("Перейти");

}
