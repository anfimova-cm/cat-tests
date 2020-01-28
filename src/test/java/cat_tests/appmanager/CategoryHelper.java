package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CategoryHelper {
    private ChromeDriver driver;

    public CategoryHelper(ChromeDriver driver) {
        this.driver = driver;
    }

    public void renameCategory(String renameTo) {
        driver.findElement(By.xpath(".//label[contains(@class, 'text-field')]" +
                "//div[text()='Заголовок']/../input")).clear();
        driver.findElement(By.xpath(".//label[contains(@class, 'text-field')]" +
                "//div[text()='Заголовок']/../input")).sendKeys(renameTo);
        driver.findElement(By.xpath(".//div[contains(@class, 'view-menu-panel')]" +
                "//*[text()='Сохранить изменения']")).click();
    }

    public void gotoCategorySettings(String categoryId) {
        driver.findElement(By.xpath(".//a[@href='/catalog/categories/" + categoryId + "']")).click();
    }

    public void showCategory(final String categoryName) {
        driver.findElement(By.xpath(".//div[contains(@class, 'category-folding-card')]" +
                "//*[text()='" + categoryName + "']")).click();
        driver.findElement(By.xpath(".//div[contains(@class, 'category-folding-card')]" +
                "//*[text()='Показать все']")).click();
    }
}
