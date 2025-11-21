package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    
    private By health1 = By.xpath("//div[@class='MuiBox-root jss106']");
    
    public void selectHealthCategory() {

        driver.findElement(health1).click();  
    }
}
