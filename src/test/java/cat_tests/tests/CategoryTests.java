package cat_tests.tests;

import cat_tests.model.CategoryData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CategoryTests extends TestBase {

    @Test
    public void renameCategoryTest() {

        // ��������, ���� ��� - ��������

        app.getNavigationHelper().gotoSection("������");
        List<CategoryData> before = app.getCategoryHelper().getCategoryList();

        app.getCategoryHelper().gotoCategorySettings(new CategoryData("Test"));
        app.getCategoryHelper().renameCategory("Test Renamed");
        app.getNavigationHelper().gotoSection("������");

        List<CategoryData> after = app.getCategoryHelper().getCategoryList();
        Assert.assertEquals(before.size(), after.size());

        // assert ����� ��� = ��������
        // ������������� �������

        // ���������� HashSet - ���������������
        // Assert.assertNotEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Assert.assertNotEquals(before, after);

    }

}
