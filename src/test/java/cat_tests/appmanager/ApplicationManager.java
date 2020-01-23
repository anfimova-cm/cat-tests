package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApplicationManager extends SectionNavigationHelper {

    public void renameCategory(String renameTo) {
        sessionHelper.driver.findElement(By.xpath(".//label[contains(@class, 'text-field')]" +
                "//div[text()='Заголовок']/../input")).clear();
        sessionHelper.driver.findElement(By.xpath(".//label[contains(@class, 'text-field')]" +
                "//div[text()='Заголовок']/../input")).sendKeys(renameTo);
        sessionHelper.driver.findElement(By.xpath(".//div[contains(@class, 'view-menu-panel')]" +
                "//*[text()='Сохранить изменения']")).click();
    }

    public void gotoCategorySettings(String categoryId) {
        sessionHelper.driver.findElement(By.xpath(".//a[@href='/catalog/categories/" + categoryId + "']")).click();
    }

    public void showAllCategory(final String categoryName) {
        sessionHelper.driver.findElement(By.xpath(".//div[contains(@class, 'category-folding-card')]" +
                "//*[text()='" + categoryName + "']")).click();
        sessionHelper.driver.findElement(By.xpath(".//div[contains(@class, 'category-folding-card')]" +
                "//*[text()='Показать все']")).click();
    }

    public void selectShowcase(final String marketEntityName) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'entity-card')]//*[text()='" +
//                marketEntityName + "']")));
        WebElement element = sessionHelper.driver.findElement(By.xpath(".//div[contains(@class, 'entity-card')]//*[text()='" +
                marketEntityName + "']"));
        ((JavascriptExecutor) sessionHelper.driver).executeScript("arguments[0].scrollIntoView(true)", element);
//        driver.findElement(By.xpath(".//div[contains(@class, 'entity-card')]//*[text()='" +
//                marketEntityName + "']")).click();
        element.click();
    }

    public void openMarketEntityPage() {
        sessionHelper.driver.findElement(By.linkText("Перейти")).click();
    }

    public void setShowNever() {
        sessionHelper.driver.findElement(By.xpath(".//div[contains(@class, 'section-card')]//*[text()='Закрыть для всех']")).click();
    }

    public void saveChanges() {
        sessionHelper.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Сохранить изменения']")));
        sessionHelper.driver.findElement(By.xpath(".//button[text()='Сохранить изменения']")).click();
    }

    public void scrollPage() {
        sessionHelper.js.executeScript("window.scrollTo(0,0)");
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
