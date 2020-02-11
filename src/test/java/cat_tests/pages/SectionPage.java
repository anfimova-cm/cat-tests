package cat_tests.pages;

import org.openqa.selenium.By;

public class SectionPage {

    public final By main_menu_locator =
            By.xpath(".//div[contains(@class, 'view-menu-panel')]//button[contains(@class, 'SectionSelectorButton')]");
    public final By title_in_menu_locator =
            By.xpath(".//div[contains(@class, 'SectionSelectorDropMenu')]//span");

}
