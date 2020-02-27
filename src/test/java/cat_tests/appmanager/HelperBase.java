package cat_tests.appmanager;

import cat_tests.pages.PageBase;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HelperBase extends PageBase {

    protected ChromeDriver driver;

    public HelperBase(ChromeDriver driver) {
        this.driver = driver;
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch ( NoSuchElementException ex) {
            return false;
        }
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch ( NoSuchElementException ex) {
            return false;
        }
    }

    protected boolean isClickable(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (ElementNotInteractableException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    protected boolean isClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (ElementNotInteractableException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    protected void click3(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (ElementNotInteractableException ex) {
            ex.printStackTrace();
        }
    }

    protected void click3(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (ElementNotInteractableException ex) {
            ex.printStackTrace();
        }
    }

    public void click(By locator) {
        if (! isElementPresent(locator) || ! isClickable(locator)) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            driver.findElement(locator).click();
        }
    }

    public void click(WebElement element) {
        if (! isElementPresent(element) || ! isClickable(element)) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            element.click();
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

//    protected void isClickable(WebElement element) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, 5);
//            wait.until(ExpectedConditions.elementToBeClickable(element));
//        } catch (ElementNotInteractableException ex) {
//            ex.printStackTrace();
//        }
//    }

}
