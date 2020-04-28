package cat_tests.appmanager;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class ApplicationManager {

    private Properties properties;
    private NavigationHelper navigationHelper;
    private SectionHelper sectionHelper;
    private CategoryHelper categoryHelper;
    private MarketEntityHelper marketEntityHelper;
    private ShowcaseHelper showcaseHelper;
    private TargetingHelper targetingHelper;

    public ApplicationManager() {
        properties = new Properties();
    }

    public void init() throws IOException {

        Selenide driver = new Selenide();
        navigationHelper = new NavigationHelper(driver);
        sectionHelper = new SectionHelper(driver);
        categoryHelper = new CategoryHelper(driver);
        marketEntityHelper = new MarketEntityHelper(driver);
        showcaseHelper = new ShowcaseHelper(driver);
        targetingHelper = new TargetingHelper(driver);

        properties.load(new FileReader(new File("src/test/java/cat_tests/conf/test.properties")));

        Configuration.browser = properties.getProperty("browser.type");
        Configuration.startMaximized = Boolean.parseBoolean(properties.getProperty("browser.startMaximized"));
        open(properties.getProperty("cat.url"));
    }

    public void stop() {
//        close(); Selenide закрывает сам
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SectionHelper section() {
        return sectionHelper;
    }

    public CategoryHelper category() {
        return categoryHelper;
    }

    public MarketEntityHelper getMarketEntityHelper() {
        return marketEntityHelper;
    }

    public ShowcaseHelper getShowcaseHelper() {
        return showcaseHelper;
    }

    public TargetingHelper getTargetingHelper() {
        return targetingHelper;
    }

}
