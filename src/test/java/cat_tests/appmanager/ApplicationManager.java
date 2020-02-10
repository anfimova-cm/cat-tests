package cat_tests.appmanager;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private ChromeDriver driver;
    private MarketEntityHelper marketEntityHelper;
    private NavigationHelper navigationHelper;
    private SectionHelper sectionHelper;
    private CategoryHelper categoryHelper;
    private TargetingHelper targetingHelper;
    private ShowcaseHelper showcaseHelper;

    public void init() {
        driver = new ChromeDriver();
        navigationHelper = new NavigationHelper(driver);
        sectionHelper = new SectionHelper(driver);
        categoryHelper = new CategoryHelper(driver);
        marketEntityHelper = new MarketEntityHelper(driver);
        targetingHelper = new TargetingHelper(driver);
        showcaseHelper = new ShowcaseHelper(driver);

        driver.manage().window().maximize();
        driver.get("https://catalog-administration-tool-gogol.web-dev.cardsmobile.ru/catalog");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void stop() {
        driver.quit();
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

    public TargetingHelper getTargetingHelper() {
        return targetingHelper;
    }

    public ShowcaseHelper getShowcaseHelper() {
        return showcaseHelper;
    }
}
