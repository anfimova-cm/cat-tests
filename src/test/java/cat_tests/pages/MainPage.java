package cat_tests.pages;

import org.openqa.selenium.By;

public class MainPage {

    public final By catalog_page = By.xpath("//a[@href='/catalog']");
    public final By bread_crumb_catalog =
            By.xpath("//div[contains(@class, 'BreadcrumbSection')]//a[@href='/catalog']");

}
