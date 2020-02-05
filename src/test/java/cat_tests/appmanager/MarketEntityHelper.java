package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketEntityHelper extends HelperBase {

    //private WebDriverWait wait;

    public MarketEntityHelper(ChromeDriver driver) {
        super(driver);
        //wait = new WebDriverWait(driver, 10);
    }

    public void openMarketEntityPage() {
        click(By.linkText("Перейти"));
    }

    public void saveMarketEntityChanges() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Сохранить изменения']")));
        click(By.xpath(".//button[text()='Сохранить изменения']"));
    }

}
