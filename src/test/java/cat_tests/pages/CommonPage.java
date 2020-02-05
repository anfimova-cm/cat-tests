package cat_tests.pages;

import org.openqa.selenium.By;

public class CommonPage {

    // Category
    protected final By save_category_changes_locator =
            By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[text()='Сохранить изменения']");
    protected final By category_header_locator =
            By.xpath(".//label[contains(@class, 'text-field')]//div[text()='Заголовок']/../input");
    protected final By show_all_category_locator =
            By.xpath(".//div[contains(@class, 'category-folding-card')]//*[text()='Показать все']");
    protected final By category_name_locator =
            By.xpath(".//div[contains(@class, 'CategoryTitleContainer')]");
    protected final By category_settings_locator =
            By.xpath(".//div[contains(@class, 'category-folding-card')]//*[contains(@href, 'gear')]");

    // Section
    protected final By catalog_main_page_locator =
            By.xpath(".//a[@href='/catalog']");
    protected final By section_menu_locator =
            By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[text()='Главная']");
    protected final By section_name_locator =
            By.xpath(".//div[contains(@class, 'SectionSelectorDropMenu')]//span");

}
