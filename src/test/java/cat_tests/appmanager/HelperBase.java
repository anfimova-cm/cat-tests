package cat_tests.appmanager;

import cat_tests.pages.PageBase;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HelperBase extends PageBase {

    protected Selenide driver;

    public HelperBase(Selenide driver) {
        this.driver = driver;
    }

    /**
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
    **/

    protected static void click(By locator) {
        $(locator).shouldBe(visible).shouldBe(enabled).click();
    }

    protected static void click(SelenideElement element) {
        element.shouldBe(visible).shouldBe(enabled).click();
    }

    protected static void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = $(locator).getText();
            if (!text.equals(existingText)) {
                $(locator).clear();
                $(locator).sendKeys(text);
            }
        }
    }

    protected void attach(By locator, File file) {
        if (file != null) {
            $(locator).sendKeys(file.getAbsolutePath());
        }
    }

}
