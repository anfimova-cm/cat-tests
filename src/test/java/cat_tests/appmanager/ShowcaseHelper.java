package cat_tests.appmanager;

import cat_tests.model.ShowcaseData;
import com.codeborne.selenide.Selenide;

public class ShowcaseHelper extends HelperBase {

    public ShowcaseHelper(Selenide driver) {
        super(driver);
    }

    public void select(ShowcaseData showcase) {
//        click(By.xpath(".//div[contains(@class, 'entity-card')]/div[contains(text(), '" + offerName + "')]/.."));
    }

}
