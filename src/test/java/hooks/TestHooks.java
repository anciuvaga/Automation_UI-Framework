package hooks;

import com.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.TestContext;
import managers.FileReaderManager;
import org.apache.log4j.PropertyConfigurator;


public class TestHooks {

    TestContext testContext;

    public TestHooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setUp() {
        PropertyConfigurator.configure(FileReaderManager.getInstance().getConfigFileReader().getLogConfigPath());
        Reporter.assignAuthor("Automation Framework - Andrei Ciuvaga");
    }


    @After
    public void tearDown() {
        testContext.getWebDriverManager().closeDiver();
    }
}
