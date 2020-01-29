package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ChromeDriver driver) {
        super(driver);
    }

    public void scrollPage() {
        driver.executeScript("window.scrollTo(0,0)");
    }

    public void gotoCatalogPage() {
        click(By.xpath(".//a[@href='/catalog']"));
    }

    public void openSectionMenu() {
        click(By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[text()='Главная']"));
    }

    public void gotoSection(String sectionName) {
        click(By.xpath(".//a[@href='/catalog']"));
        click(By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[text()='Главная']"));
        click(By.xpath(".//button[contains(@class, 'drop-menu')]//*[text()='" + sectionName + "']"));
    }

}