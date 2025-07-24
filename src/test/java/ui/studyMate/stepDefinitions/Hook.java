package ui.studyMate.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;

public class Hook {

    public WebDriver driver;

    @Before
    public void setup(){
        driver = Driver.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(ConfigReader.readProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotCucumber(driver, scenario);
        Driver.closeDriver();
    }

}
