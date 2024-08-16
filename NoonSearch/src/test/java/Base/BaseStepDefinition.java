package Base;

import Pages.*;
import org.openqa.selenium.WebDriver;

public class BaseStepDefinition {
    public static void setDriver(WebDriver driver2){
         driver=driver2;
    }
    public static WebDriver driver;
}
