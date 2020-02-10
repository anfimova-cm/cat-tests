package cat_tests.tests;

import cat_tests.model.Categories;
import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import cat_tests.model.Sections;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CategoryTests extends TestBase {

    @DataProvider


    @BeforeMethod
    public Object[] ensurePreconditions() {
    // TODO: �������� ������� ���������, ���� ��� - ��������

        return new Object[0];
    }

    @Test (enabled = false)
    public void createCategoryTest() {

    }

    @Test (enabled = true)
    public void renameCategoryTest() {

        SectionData section = new SectionData().withName("������");
        CategoryData category = new CategoryData().withName("Test");
        String name = category.getTitle();
        String testName = "Test Renamed";

        app.section().open(section);
        Categories beforeAll = app.category().all();
        app.category().settings(category);
        app.category().rename(category, testName);

        // ��������
        app.section().open(section);
        Categories afterRename = app.category().all();
        assertThat(beforeAll.size(), equalTo(afterRename.size()));

        // ��������� � ����� ������ ���� � ������ ���������
        assertThat(app.category().searchRenamed(category), equalTo(testName));

        // �������������� �������
        app.category().settings(category);
        app.category().rename(category, name);
        category.withName(name);

        // ��������, ��� �� �������� ��� ���� �� ��������������
        app.section().open(section);
        Categories afterAll = app.category().all();
        assertThat(beforeAll.size(), equalTo(afterAll.size()));
        assertThat(beforeAll, equalTo(afterAll));
    }

    @Test (enabled = false)
    public void deleteCategoryTest() {

    }

}
