package cat_tests.tests;

import cat_tests.model.Categories;
import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ModifyCategoryTests extends TestBase {

    @DataProvider(name = "dataCategoryTests")
    public Iterator<Object[]> dataProviderMethod() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {
                new SectionData().withTitle("���������"),
                new CategoryData().withTitle("TestCategory")
        });
        return list.iterator();
    }

    @BeforeMethod
    public void ensurePreconditions() {
        app.section().open(new SectionData().withTitle("���������"));
        if (app.category().set().size() == 1) {
            app.category().create(new CategoryData().withTitle("TestCategory"));
        }
    }

    @Test(enabled = true, dataProvider = "dataCategoryTests")
    public void renameCategoryTest(SectionData section, CategoryData category) {
        String testTitle = "TestCategoryRenamed";

        app.section().open(section);
        Categories before = app.category().set();
        app.category().rename(category, testTitle);

        app.goTo().catalog();
        app.section().open(section);
        Categories after = app.category().set();
        // TODO: �������� ��������� ��������
        assertThat(before.size(), equalTo(after.size()));
        assertThat(before.without(before.stream().filter(c -> c.getUid().equals(category.getUid())).findFirst().get()),
                equalTo(after.without(after.stream().filter(c -> c.getUid().equals(category.getUid())).findFirst().get())));
        assertThat(category.getTitle(), equalTo(testTitle));
    }

}
