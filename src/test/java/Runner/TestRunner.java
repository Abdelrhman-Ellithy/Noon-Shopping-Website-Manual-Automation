package Runner;
import Ellithium.DriverSetup.BDDSetup;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        glue = "stepDefinitions", // path to your stepDefinitions package, note you should use . instead of /
        features="src/main/resources/features" // path to your features folder
)
public class TestRunner extends BDDSetup {
}