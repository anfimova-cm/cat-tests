package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketEntityHelper {

    private ChromeDriver driver;
    private WebDriverWait wait;

    public MarketEntityHelper(ChromeDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void openMarketEntityPage() {
        driver.findElement(By.linkText("Перейти")).click();
    }

    public void saveMarketEntityChanges() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Сохранить изменения']")));
        driver.findElement(By.xpath(".//button[text()='Сохранить изменения']")).click();
    }

    public void saveMarketEntityChanges1() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Сохранить изменения']")));
        driver.findElement(By.xpath(".//button[text()='Сохранить изменения']")).click();
    }

}
