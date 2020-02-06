package cat_tests.pages;

import org.openqa.selenium.By;

public class MarketEntityPage {

    public final By save_changes_locator = By.xpath(".//button[text()='Сохранить изменения']");
    public final By show_never_locator =
            By.xpath(".//div[contains(@class, 'section-card')]//*[text()='Закрыть для всех']");

}
