package UI.Base;
import Ellithium.DriverSetup.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseStepDefinition {

    protected WebDriver driver;

    protected BaseStepDefinition() {
        driver = DriverFactory.getDriver();  // Retrieve WebDriver instance for this thread
    }
}
