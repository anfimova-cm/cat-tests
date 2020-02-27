package cat_tests.tests;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    private static String url = "https://catalog-administration-tool-gogol.web-dev.cardsmobile.ru/catalog";
    private static By catalog = By.xpath("//a[@href='/catalog']");
    private static By section_title = By.xpath("//div[contains(@class, 'view-menu-panel')]//button[contains(@class, 'SectionSelectorButton')]");
    private static By drop_title = By.xpath("//div[contains(@class, 'SectionSelectorDropMenu')]//button");
    private static By plus = By.xpath("//div[contains(@class, 'view-menu-panel')]//*[contains(@href, 'plus')][1]");
    private static By category_title = By.xpath("//div[contains(@class, 'CategoryTitleContainer')]");
    private static By input = By.xpath("//label[contains(@class, 'text-field')]//div[text()='���������']/../input");
    private static By create = By.xpath("//div[contains(@class, 'view-menu-panel')]//*[text()='�������']");

    private static void click(By locator) {
        $(locator).shouldBe(visible).shouldBe(enabled).click();
    }

    private static void type(By locator, String text) {
        click(locator);
        $(locator).sendKeys(text);
    }

    private static void select() {
        click(catalog);
        click(section_title);
        $$(drop_title).findBy(text("���������")).click();
    }

    private static void create() {
        click(plus);
        type(input, "Title");
        click(create);
    }

    private static void count(By locator) {
        $$(locator);
    }

    public static void main(String[] args) {
        open(url);
        select();
        create();
        select();
        $$(category_title).shouldHaveSize(3);
    }

}
