package cat_tests.pages;

import org.openqa.selenium.By;

public class CategoryPage {

    public final By title =
            By.xpath("//div[contains(@class, 'CategoryTitleContainer')]");
    public final By uid =
            By.xpath("//div[contains(@class, 'CategoryIdContainer')]");
    public final By add_category =
            By.xpath("//div[contains(@class, 'view-menu-panel')]//*[contains(@href, 'plus')][1]");
    public final By show_all =
            By.xpath("//div[contains(@class, 'category-folding-card')]//*[text()='Показать все']");
    public final By settings =
            By.xpath("//div[contains(@class, 'category-folding-card')]//*[contains(@href, 'gear')]");
    public final By title_input =
            By.xpath("//label[contains(@class, 'text-field')]//div[text()='Заголовок']/../input");
    public final By save_changes =
            By.xpath("//div[contains(@class, 'view-menu-panel')]//*[text()='Сохранить изменения']");
    public final By create_button =
            By.xpath("//div[contains(@class, 'view-menu-panel')]//*[text()='Создать']");
    public final By target_page = By.linkText("Перейти");
    public final By delete_button =
            By.xpath("//div[contains(@class, 'view-menu-panel')]//*[contains(@href, 'trash-can')]");

}
