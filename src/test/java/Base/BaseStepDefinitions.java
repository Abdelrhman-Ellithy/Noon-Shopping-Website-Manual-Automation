package Base;
import Ellithium.core.driver.DriverFactory;
import Ellithium.core.driver.LocalDriverType;
import org.openqa.selenium.WebDriver;
public class BaseStepDefinitions {
    protected WebDriver driver;
    public BaseStepDefinitions(){
        driver= DriverFactory.getNewLocalDriver(LocalDriverType.Chrome);
    }
}