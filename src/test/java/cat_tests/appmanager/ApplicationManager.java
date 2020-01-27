package cat_tests.appmanager;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private ChromeDriver driver;
    //private JavascriptExecutor js;

    private MarketEntityHelper marketEntityHelper;
    private NavigationHelper navigationHelper;
    private CategoryHelper categoryHelper;
    private TargetingHelper targetingHelper;
    private ShowcaseHelper showcaseHelper;

    public void init() {
        driver = new ChromeDriver();
        //js = (JavascriptExecutor) driver;

        navigationHelper = new NavigationHelper(driver);
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

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public CategoryHelper getCategoryHelper() {
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
