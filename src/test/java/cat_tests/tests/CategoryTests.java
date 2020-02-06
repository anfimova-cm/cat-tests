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
        final String name = category.getName();
        final String rename = "Test Renamed";

        app.getNavigationHelper().gotoSection(section);
        List<CategoryData> beforeAll = app.getCategoryHelper().getCategoryList();
        app.getCategoryHelper().gotoCategorySettings(category);
        app.getCategoryHelper().renameCategory(rename);
        category.setName(rename);

        // ��������
        app.getNavigationHelper().gotoSection(section);
        List<CategoryData> afterRename = app.getCategoryHelper().getCategoryList();
        Assert.assertEquals(beforeAll.size(), afterRename.size());

        // ��������� � ����� ������ ���� � ������ ���������
        Assert.assertEquals(app.getCategoryHelper().searchRenamedCategory(category), rename);

        // �������������� �������
        app.getCategoryHelper().gotoCategorySettings(category);
        app.getCategoryHelper().renameCategory(name);
        category.setName(name);

        // ��������, ��� �� �������� ��� ���� �� ��������������
        app.getNavigationHelper().gotoSection(section);
        List<CategoryData> afterAll = app.getCategoryHelper().getCategoryList();
        Assert.assertEquals(beforeAll.size(), afterAll.size());
        Assert.assertEquals(beforeAll, afterAll);

    }

}
