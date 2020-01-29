package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TargetingHelper extends HelperBase {

    public TargetingHelper(ChromeDriver driver) {
        super(driver);
    }

    public void setShowNever() {
        click(By.xpath(".//div[contains(@class, 'section-card')]//*[text()='Закрыть для всех']"));
    }
}
