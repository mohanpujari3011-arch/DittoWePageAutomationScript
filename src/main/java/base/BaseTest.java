package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = DriverFactory.getDriver();
    }

    @AfterClass
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
