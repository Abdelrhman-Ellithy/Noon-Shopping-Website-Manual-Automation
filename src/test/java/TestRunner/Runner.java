package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"stepDefinitions", "Base"},
        plugin = {"pretty", "html:Test-Output/cucumber-reports/cucumber.html",
                "json:Test-Output/cucumber-reports/cucumber.json",
                "junit:Test-Output/cucumber-reports/cucumber.xml"},
        monochrome = true,
        dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests {

        @Parameters({"BrowserName"})
        @BeforeClass(alwaysRun = true)
        public void setUp(@Optional("Chrome") String BrowserName) {
                System.setProperty("BrowserName", BrowserName);
        }
        @AfterClass(alwaysRun = true)
        public void tareDown(){
                System.clearProperty("BrowserName");
        }
        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}