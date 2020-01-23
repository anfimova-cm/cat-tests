package cat_tests.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class SessionHelper {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected WebDriverWait wait;

    public void init() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://catalog-administration-tool-gogol.web-dev.cardsmobile.ru/catalog");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void stop() {
        driver.quit();
    }
}
