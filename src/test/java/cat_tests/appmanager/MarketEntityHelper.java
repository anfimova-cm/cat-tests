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
    }

    public void openMarketEntityPage() {
        driver.findElement(By.linkText("�������")).click();
    }

    public void saveMarketEntityChanges() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='��������� ���������']")));
        driver.findElement(By.xpath(".//button[text()='��������� ���������']")).click();
    }

}
