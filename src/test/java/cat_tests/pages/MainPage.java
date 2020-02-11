package cat_tests.pages;

import org.openqa.selenium.By;

public class MainPage {

    public final By catalog_page_locator = By.xpath(".//a[@href='/catalog']");
    public final By bread_crumb_catalog_locator =
            By.xpath(".//div[contains(@class, 'BreadcrumbSection')]//a[@href='/catalog']");

}
