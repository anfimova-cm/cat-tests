package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShowcaseHelper {

    private ChromeDriver driver;

    public ShowcaseHelper(ChromeDriver driver) {
        this.driver = driver;
    }

    public void selectShowcase(final String marketEntityName) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'entity-card')]//*[text()='" +
//                marketEntityName + "']")));
        WebElement element = driver.findElement(By.xpath(".//div[contains(@class, 'entity-card')]//*[text()='" +
                marketEntityName + "']"));
        driver.executeScript("arguments[0].scrollIntoView(true)", element);
//        driver.findElement(By.xpath(".//div[contains(@class, 'entity-card')]//*[text()='" +
//                marketEntityName + "']")).click();
        element.click();
    }
}
