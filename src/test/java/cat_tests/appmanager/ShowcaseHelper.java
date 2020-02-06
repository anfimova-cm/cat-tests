package cat_tests.appmanager;

import cat_tests.model.ShowcaseData;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShowcaseHelper extends HelperBase {

    public ShowcaseHelper(ChromeDriver driver) {
        super(driver);
    }

    public void selectShowcase(ShowcaseData showcase) {
//        click(By.xpath(".//div[contains(@class, 'entity-card')]/div[contains(text(), '" + offerName + "')]/.."));
    }

}
