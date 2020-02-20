package cat_tests.tests;

import cat_tests.model.Categories;
import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import org.testng.IDataProviderInterceptor;
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
                // Временно секция без секции
                new SectionData().withTitle("Без секции"),
                new CategoryData().withTitle("TestCategory")
        });
        return list.iterator();
    }

    @BeforeMethod
    public void ensurePreconditions(SectionData section) {
        app.section().open(section);
        if (app.category().set().size() == 0) {
            app.category().create(new CategoryData().withTitle("TestCategory"));
        }
    }

    @Test(enabled = true, dataProvider = "dataCategoryTests")
    public void renameCategoryTest(SectionData section, CategoryData category) {
        // TODO: проверка наличия категории, если нет - создание
        String testTitle = "TestCategoryRenamed";

        app.section().open(section);
        Categories before = app.category().set();
        app.category().rename(category.withTitle(testTitle));

        app.goTo().catalog();
        app.section().open(section);
        Categories after = app.category().set();
        assertThat(before.size(), equalTo(after.size()));
        assertThat(before.without(category), equalTo(after.without(category)));
        assertThat(category.getTitle(), equalTo(testTitle));
    }

}
