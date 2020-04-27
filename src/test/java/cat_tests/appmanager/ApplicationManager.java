package cat_tests.appmanager;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.open;

public class ApplicationManager {

//    private ChromeDriver driver;
    private Selenide driver;
    private NavigationHelper navigationHelper;
    private SectionHelper sectionHelper;
    private CategoryHelper categoryHelper;
    private MarketEntityHelper marketEntityHelper;
    private ShowcaseHelper showcaseHelper;
    private TargetingHelper targetingHelper;
    private MongoHelper mongoHelper;

    public void init() {

//        driver = new ChromeDriver();
        driver = new Selenide();
        navigationHelper = new NavigationHelper(driver);
        sectionHelper = new SectionHelper(driver);
        categoryHelper = new CategoryHelper(driver);
        marketEntityHelper = new MarketEntityHelper(driver);
        showcaseHelper = new ShowcaseHelper(driver);
        targetingHelper = new TargetingHelper(driver);
        mongoHelper = new MongoHelper();

        Configuration.browser="chrome";
        Configuration.startMaximized=true;
        open("https://catalog-administration-tool-gogol.web-dev.cardsmobile.ru/catalog");

//        driver.manage().window().maximize();
//        driver.get("https://catalog-administration-tool-gogol.web-dev.cardsmobile.ru/catalog");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void stop() {
//        Selenide закрывает сам
//        close();
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

    public MongoHelper getMongoHelper() {
        return mongoHelper;
    }
}
