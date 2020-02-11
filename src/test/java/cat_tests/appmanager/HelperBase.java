package cat_tests.appmanager;

import cat_tests.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class HelperBase extends PageBase {

    protected ChromeDriver driver;

    public HelperBase(ChromeDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (ElementNotInteractableException ex) {
            ex.printStackTrace();
        }
    }

    protected void click(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (ElementNotInteractableException ex) {
            ex.printStackTrace();
        }
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = driver.findElement(locator).getText();
            if (!text.equalsIgnoreCase(existingText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void attach(By locator, File file) {
        if (file != null) {
            driver.findElement(locator).sendKeys(file.getAbsolutePath());

        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch ( NoSuchElementException ex) {
            return false;
        }
    }

//    protected void isClickable(By locator) {
//        try {
//            WebElement element = driver.findElement(locator);
//            WebDriverWait wait = new WebDriverWait(driver, 5);
//            wait.until(ExpectedConditions.elementToBeClickable(element));
//        } catch (ElementNotInteractableException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    protected void isClickable(WebElement element) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, 5);
//            wait.until(ExpectedConditions.elementToBeClickable(element));
//        } catch (ElementNotInteractableException ex) {
//            ex.printStackTrace();
//        }
//    }

}
