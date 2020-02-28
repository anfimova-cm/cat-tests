package cat_tests.appmanager;

import cat_tests.model.SectionData;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class SectionHelper extends HelperBase {

    public SectionHelper(Selenide driver) {
        super(driver);
    }

    public void open(SectionData section) {
        click(getSectionPage().main_menu);
        List<SelenideElement> names = $$(getSectionPage().title_in_menu);
        for (int i=0; i < names.size(); i++) {
            if (names.get(i).getText().equalsIgnoreCase(section.getTitle())) {
                click(names.get(i));
                break;
            }
        }
    }

}
