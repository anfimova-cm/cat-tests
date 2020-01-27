package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TargetingHelper {

    private ChromeDriver driver;

    public TargetingHelper(ChromeDriver driver) {
        this.driver = driver;
    }

    public void setShowNever() {
        driver.findElement(By.xpath(".//div[contains(@class, 'section-card')]//*[text()='Закрыть для всех']")).click();
    }
}
