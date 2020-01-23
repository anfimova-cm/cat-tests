package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private ChromeDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private CategoryNavigationHelper categoryNavigationHelper;

    public void init() {
        driver = new ChromeDriver();
        categoryNavigationHelper = new CategoryNavigationHelper(driver);
        // тут было js = (JavascriptExecutor) driver, но он redundant
        js = driver;
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.get("https://catalog-administration-tool-gogol.web-dev.cardsmobile.ru/catalog");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void stop() {
        driver.quit();
    }

    public void gotoMainSection() {
        driver.findElement(By.xpath(".//a[@href='/catalog']")).click();
    }

    public void renameCategory(String renameTo) {
        driver.findElement(By.xpath(".//label[contains(@class, 'text-field')]" +
                "//div[text()='Заголовок']/../input")).clear();
        driver.findElement(By.xpath(".//label[contains(@class, 'text-field')]" +
                "//div[text()='Заголовок']/../input")).sendKeys(renameTo);
        driver.findElement(By.xpath(".//div[contains(@class, 'view-menu-panel')]" +
                "//*[text()='Сохранить изменения']")).click();
    }

    public void gotoCategorySettings(String categoryId) {
        driver.findElement(By.xpath(".//a[@href='/catalog/categories/" + categoryId + "']")).click();
    }

    public void showAllCategory(final String categoryName) {
        driver.findElement(By.xpath(".//div[contains(@class, 'category-folding-card')]" +
                "//*[text()='" + categoryName + "']")).click();
        driver.findElement(By.xpath(".//div[contains(@class, 'category-folding-card')]" +
                "//*[text()='Показать все']")).click();
    }

    public void selectShowcase(final String marketEntityName) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'entity-card')]//*[text()='" +
//                marketEntityName + "']")));
        WebElement element = driver.findElement(By.xpath(".//div[contains(@class, 'entity-card')]//*[text()='" +
                marketEntityName + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
//        driver.findElement(By.xpath(".//div[contains(@class, 'entity-card')]//*[text()='" +
//                marketEntityName + "']")).click();
        element.click();
    }

    public void openMarketEntityPage() {
        driver.findElement(By.linkText("Перейти")).click();
    }

    public void setShowNever() {
        driver.findElement(By.xpath(".//div[contains(@class, 'section-card')]//*[text()='Закрыть для всех']")).click();
    }

    public void saveMarketEntityChanges() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Сохранить изменения']")));
        driver.findElement(By.xpath(".//button[text()='Сохранить изменения']")).click();
    }

    public void scrollPage() {
        js.executeScript("window.scrollTo(0,0)");
    }

    public CategoryNavigationHelper getCategoryNavigationHelper() {
        return categoryNavigationHelper;
    }
}
