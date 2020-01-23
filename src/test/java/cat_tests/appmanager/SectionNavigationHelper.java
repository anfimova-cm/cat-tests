package cat_tests.appmanager;

import org.openqa.selenium.By;

public class SectionNavigationHelper {
    protected SessionHelper sessionHelper = new SessionHelper();

    public void gotoMainPage() {
        sessionHelper.driver.findElement(By.xpath(".//a[@href='/catalog']")).click();
    }

    public void gotoDiscountPage() {
        sessionHelper.driver.findElement(By.xpath(".//a[@href='/catalog']")).click();
        sessionHelper.driver.findElement(By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[text()='Главная']")).click();
        sessionHelper.driver.findElement(By.xpath(".//button[contains(@class, 'drop-menu')]//*[text()='Карты']")).click();
    }

    public void gotoCouponsPage() {
        sessionHelper.driver.findElement(By.xpath(".//a[@href='/catalog']")).click();
        sessionHelper.driver.findElement(By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[text()='Главная']")).click();
        sessionHelper.driver.findElement(By.xpath(".//button[contains(@class, 'drop-menu')]//*[text()='Скидки']")).click();
    }
}