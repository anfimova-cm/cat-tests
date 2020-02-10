package cat_tests.tests;

import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CategoryTests extends TestBase {

    @Test
    public void renameCategoryTest() {

        // TODO: �������� ������� ���������, ���� ��� - ��������

        SectionData section = new SectionData("������");

        CategoryData category = new CategoryData("Test");
        final String name = category.getTitle();
        final String rename = "Test Renamed";

        app.section().open(section);
        List<CategoryData> beforeAll = app.category().list();
        app.category().settings(category);
        app.category().rename(rename);
        category.setTitle(rename);

        // ��������
        app.goTo().catalog();
        app.section().open(section);
        List<CategoryData> afterRename = app.category().list();
        Assert.assertEquals(beforeAll.size(), afterRename.size());
        // TODO: ���������, ��� ����� ��� ���� � ������ � = ��������
        // � ������ ��� �� �����

        Assert.assertNotEquals(beforeAll, afterRename);

        // �������������� �������
        app.category().settings(category);
        app.category().rename(name);
        category.setTitle(name);

        // ��������, ��� �� �������� ��� ���� �� ��������������
        app.goTo().catalog();
        app.section().open(section);
        List<CategoryData> afterAll = app.category().list();
        Assert.assertEquals(beforeAll.size(), afterAll.size());
        Assert.assertEquals(beforeAll, afterAll);

    }

}
