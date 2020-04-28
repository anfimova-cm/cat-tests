package cat_tests.tests;

import cat_tests.model.Categories;
import cat_tests.model.CategoryData;
import cat_tests.model.SectionData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateCategoryTests extends TestBase {

    @DataProvider(name = "dataCategoryTests")
    public Iterator<Object[]> dataProviderMethod() {
        List<Object[]> list = new ArrayList<Object[]>();
        // TODO: сделать чтение данных из json
        list.add(new Object[] {
            new SectionData().withTitle("Тест"),
            new CategoryData()
        });
        return list.iterator();
    }

    @Test(dataProvider = "dataCategoryTests")
    public void createCategoryTest(SectionData section, CategoryData category) {
        String title = "TestCategory";

        app.section().open(section);
        Categories before = app.category().set();
        app.category().create(category.withTitle(title));
        app.goTo().catalog();
        app.section().open(section);
        Categories after = app.category().set();
        assertThat(before.size(), equalTo(after.size() - 1));
        assertThat(before.with(after.stream().filter(c -> c.getUid().equals(category.getUid())).findFirst().get()),
                equalTo(after));
    }

}
