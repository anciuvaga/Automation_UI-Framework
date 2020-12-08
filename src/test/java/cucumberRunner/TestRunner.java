package cucumberRunner;

import com.cucumber.listener.Reporter;
import managers.FileReaderManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/featureFiles",
        glue = {"stepsDefinitions","hooks"},
        tags = {"@priority-1, @priority-2, @priority-3"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml", "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
        monochrome = true,
        dryRun = false,
        strict = false

)

public class TestRunner {

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigFileReader().getReportConfigPath()));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "Windows 10" + " 64 Bit");
        Reporter.setSystemInfo("Selenium", "3.7.0");
        Reporter.setSystemInfo("Maven", "3.6.3");
        Reporter.setSystemInfo("Java Version", "11.0.7");
    }

}