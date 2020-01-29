package cat_tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CategoryHelper extends HelperBase {

    public CategoryHelper(ChromeDriver driver) {
        super(driver);
    }

    public void renameCategory(String renameTo) {
        type(By.xpath(".//label[contains(@class, 'text-field')]//div[text()='Заголовок']/../input"), renameTo);
        click(By.xpath(".//div[contains(@class, 'view-menu-panel')]//*[text()='Сохранить изменения']"));
    }

    public void gotoCategorySettings(String categoryId) {
        click(By.xpath(".//a[@href='/catalog/categories/" + categoryId + "']"));
    }

    public void showCategory(String categoryName) {
        click(By.xpath(".//div[contains(@class, 'category-folding-card')]//*[text()='" + categoryName + "']"));
        click(By.xpath(".//div[contains(@class, 'category-folding-card')]//*[text()='Показать все']"));
    }
}
