package Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import com.google.common.io.Files;

public class Hooks {
    WebDriver driver;
    @Before
    public void setUp() {
            String browserName = System.getProperty("BrowserName", "Chrome");  // Default to Chrome if not set
            switch (browserName.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser: " + browserName);
            }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        BaseStepDefinition.setDriver(driver);
    }
    @After
    public void tearDown(Scenario scenario) throws IOException {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            switch (scenario.getStatus()) {
                case FAILED:
                    Files.move(screenshot, new File("Test-Output/ScreenShots/Failed/" + scenario.getName() + ".png"));
                    System.out.println("Test failed, screenshot captured.");
                    break;
                case PASSED:
                    Files.move(screenshot, new File("Test-Output/ScreenShots/Passed/" + scenario.getName() + ".png"));
                    System.out.println("Test passed, screenshot captured.");
                    break;
                case SKIPPED:
                    Files.move(screenshot, new File("Test-Output/ScreenShots/Skipped/" + scenario.getName() + ".png"));
                    System.out.println("Test skipped, screenshot captured.");
                    break;
            }
            driver.quit();
    }
}
