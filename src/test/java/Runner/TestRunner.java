package Runner;
import Ellithium.core.base.BDDSetup;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        glue = {"stepDefinitions","Runner"},
        features="src/main/resources/features"
)
public class TestRunner extends BDDSetup {
}