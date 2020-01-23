package cat_tests.model;

import cat_tests.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.getSessionHelper().init();
    }

    @AfterMethod
    public void tearDown() {
        app.getSessionHelper().stop();
    }

}
