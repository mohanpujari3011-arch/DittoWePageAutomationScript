package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ValidationPage {
    WebDriver driver;
    WebDriverWait wait;
 
    By totalPremiumValue = By.xpath("//span[text()='₹13,175.55']");

    public ValidationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
    }

    public void validatePremium() throws InterruptedException {
 
        String totalPremium = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPremiumValue)).getText();

        System.out.println("Premium Shown: " + totalPremium);
      
        String expectedPremium = "₹13,175.55 / 1 Year";

        if (totalPremium.equals(expectedPremium)){
            System.out.println("PASS: Total Premium is correct");
        } else {
            System.out.println("FAIL: Expected: " + expectedPremium + " but found: " + totalPremium);
        }
    }
}