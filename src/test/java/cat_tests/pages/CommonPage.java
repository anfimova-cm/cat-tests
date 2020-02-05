package cat_tests.pages;

import org.openqa.selenium.By;

public class CommonPage {

    // Main page

    protected final By catalog_main_page_locator = By.xpath(".//a[@href='/catalog']");


    protected final CategoryPage categoryPage = new CategoryPage();
    protected final SectionPage sectionPage = new SectionPage();

    public CategoryPage getCategoryPage() {
        return categoryPage;
    }

    public SectionPage getSectionPage() {
        return sectionPage;
    }
}
