package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShowcaseHelper extends HelperBase {

    public ShowcaseHelper(ChromeDriver driver) {
        super(driver);
    }

    public void selectShowcase(String offerName) {
        click(By.xpath(".//div[contains(@class, 'entity-card')]/div[contains(text(), '" + offerName + "')]/.."));
    }

}
