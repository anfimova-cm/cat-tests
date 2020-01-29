package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelperBase {

    protected ChromeDriver driver;

    public HelperBase(ChromeDriver driver) {
        this.driver = driver;
    }

    protected void click(By xpath) {
        driver.findElement(xpath).click();
    }

    protected void type(By xpath, String text) {
        driver.findElement(xpath).clear();
        driver.findElement(xpath).sendKeys(text);
    }
}
