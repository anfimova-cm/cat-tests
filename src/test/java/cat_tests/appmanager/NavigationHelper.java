package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper {
    private ChromeDriver driver;

    public NavigationHelper(ChromeDriver driver) {
        this.driver = driver;
    }

    public void scrollPage() {
        driver.executeScript("window.scrollTo(0,0)");
    }

    public void gotoMainSection() {
        driver.findElement(By.xpath(".//a[@href='/catalog']")).click();
    }

    public void gotoDiscountCategory() {
        driver.findElement(By.xpath(".//a[@href='/catalog']")).click();
        driver.findElement(By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[text()='Главная']")).click();
        driver.findElement(By.xpath(".//button[contains(@class, 'drop-menu')]//*[text()='Карты']")).click();
    }

    public void gotoCouponsCategory() {
        driver.findElement(By.xpath(".//a[@href='/catalog']")).click();
        driver.findElement(By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[text()='Главная']")).click();
        driver.findElement(By.xpath(".//button[contains(@class, 'drop-menu')]//*[text()='Скидки']")).click();
    }
}