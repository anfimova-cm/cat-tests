package cat_tests.pages;

public abstract class PageBase {

    private final MainPage mainPage = new MainPage();
    private final CategoryPage categoryPage = new CategoryPage();
    private final SectionPage sectionPage = new SectionPage();
    private final MarketEntityPage marketEntityPage = new MarketEntityPage();

    public CategoryPage getCategoryPage() {
        return categoryPage;
    }

    public SectionPage getSectionPage() {
        return sectionPage;
    }

    public MarketEntityPage getMarketEntityPage() {
        return marketEntityPage;
    }

    public MainPage getMainPage() {
        return mainPage;
    }
}
