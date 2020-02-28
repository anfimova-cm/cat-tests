package cat_tests.pages;

import org.openqa.selenium.By;

public class SectionPage {

    public final By main_menu =
            By.xpath("//div[contains(@class, 'view-menu-panel')]//button[contains(@class, 'SectionSelectorButton')]");
    public final By title_in_menu =
            By.xpath("//div[contains(@class, 'SectionSelectorDropMenu')]//button");

}
