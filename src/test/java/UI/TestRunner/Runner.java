package UI.TestRunner;
import Ellithium.DriverSetup.SETUP;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/UI",
        glue = "UI.stepDefinitions",
        tags = "@Run"
) public class Runner extends SETUP {
}
