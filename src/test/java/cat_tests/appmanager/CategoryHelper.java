package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CategoryHelper extends HelperBase {

    public CategoryHelper(ChromeDriver driver) {
        super(driver);
    }

    public void renameCategory(String renameTo) {
        type(By.xpath(".//label[contains(@class, 'text-field')]//div[text()='���������']/../input"), renameTo);
        click(By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[text()='��������� ���������']"));
    }

    public void gotoCategorySettings(String categoryName) {
        click(By.xpath(".//div[contains(@class, 'category-folding-card')]//div[text()='"
                + categoryName + "']/..//..//a[contains(@href, '/catalog/categories/')]"));
    }

    public void showCategory(String categoryName) {
        click(By.xpath(".//div[contains(@class, 'category-folding-card')]//*[text()='" + categoryName + "']"));
        click(By.xpath(".//div[contains(@class, 'category-folding-card')]//*[text()='�������� ���']"));
    }
}