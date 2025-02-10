package Runner;
import Ellithium.core.driver.DriverFactory;
import Ellithium.core.driver.LocalDriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
public class Hooks {
    @Before
    public void setupDriver(){
        DriverFactory.getNewLocalDriver(LocalDriverType.Chrome);
    }
    @After
    public void tareDown(){
        DriverFactory.quitDriver();
    }
}