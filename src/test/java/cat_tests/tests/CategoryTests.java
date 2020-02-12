package cat_tests.tests;

import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CategoryTests extends TestBase {

    @Test(enabled = true, priority = 0)
    public void createCategoryTest() {

        // �������� ������ ��� ������
        SectionData section = new SectionData().withTitle("��� ������");
        CategoryData category = new CategoryData();
        String title = "TestCategory";

        app.section().open(section);
        Set<CategoryData> before = app.category().set();
        app.category().create(category, title);
        app.goTo().catalog();
        app.section().open(section);
        Set<CategoryData> after = app.category().set();
        after.add(category);
        Assert.assertEquals(before.size(), after.size() - 1);
//        assertThat(app.category().searchRenamed(category), equalTo(title));

    }

    @Test(enabled = true, priority = 1)
    public void renameCategoryTest() {

        // TODO: �������� ������� ���������, ���� ��� - ��������

        SectionData section = new SectionData().withTitle("��� ������");
        CategoryData category = new CategoryData().withTitle("TestCategory");
        final String title = category.getTitle();
        final String testTitle = "TestCategoryRenamed";

        app.section().open(section);
        Set<CategoryData> before = app.category().set();
        app.category().settings(category);
        app.category().rename(category, testTitle);

        // ��������
        app.goTo().catalog();
        app.section().open(section);
        Set<CategoryData> after = app.category().set();
        assertThat(before.size(), equalTo(after.size()));
        // � ������ ��� �� �����
        Assert.assertNotEquals(before, after);
        // ����� ��� ���� � ������
//        assertThat(app.category().searchRenamed(category), equalTo(testTitle));

        // �������������� �������
//        app.category().settings(category);
//        app.category().rename(category, title);

        // ��������, ��� �� �������� ��� ���� �� ��������������
//        app.goTo().catalog();
//        app.section().open(section);
//        Set<CategoryData> afterAll = app.category().set();
//        assertThat(before.size(), equalTo(afterAll.size()));
//        assertThat(before, equalTo(afterAll));

    }

    @Test(enabled = true, priority = 2)
    public void deleteCategoryTest() {

        SectionData section = new SectionData().withTitle("��� ������");
        CategoryData category = new CategoryData().withTitle("TestCategoryRenamed");

        app.section().open(section);
        Set<CategoryData> before = app.category().set();
        app.category().settings(category);
        app.category().delete(category);

        app.goTo().catalog();
        app.section().open(section);
        Set<CategoryData> after = app.category().set();
        after.remove(category);
        assertThat(before.size(), equalTo(after.size() + 1));

    }
}
