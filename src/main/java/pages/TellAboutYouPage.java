package pages;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class TellAboutYouPage {

    WebDriver driver; 
    WebDriverWait wait;

    public TellAboutYouPage(WebDriver d){
        driver = d; 
        wait = new WebDriverWait(d, Duration.ofSeconds(20));
    }

    By Self = By.xpath("//span[text()='Self']");
    By Gender = By.xpath("//div[text()='Male']");
    By nextStep = By.xpath("//span[contains(text(),'Next Step')]/ancestor::button");
    By age = By.xpath("//input[@name='Selfage']");
    By pin = By.xpath("//input[@name='pincode']");
    By selectPremium = By.xpath("//span[normalize-space()='Calculate Premium']/ancestor::button");
    By Addon = By.xpath("//input[@name='Unlimited Restoration']");
    public void fillForm(int ageValue, int pincodeValue) throws InterruptedException, IOException {

         wait.until(ExpectedConditions.elementToBeClickable(Self)).click();
         wait.until(ExpectedConditions.elementToBeClickable(Gender)).click();

         Thread.sleep(2000);
        
         WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(nextStep));
         wait.until(driver -> btn.isEnabled());
         JavascriptExecutor js = (JavascriptExecutor) driver;

         js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
         try { wait.until(ExpectedConditions.elementToBeClickable(btn)).click(); }
         catch (Exception e) { js.executeScript("arguments[0].click();", btn); }
 
         wait.until(ExpectedConditions.visibilityOfElementLocated(age)).sendKeys(String.valueOf(ageValue));
         wait.until(ExpectedConditions.visibilityOfElementLocated(pin)).sendKeys(String.valueOf(pincodeValue));

         WebElement premiumBtn = wait.until(ExpectedConditions.presenceOfElementLocated(selectPremium));
         wait.until(driver -> premiumBtn.isEnabled());
         js.executeScript("arguments[0].scrollIntoView({block:'center'});", premiumBtn);

         try { wait.until(ExpectedConditions.elementToBeClickable(premiumBtn)).click(); }
         catch (Exception e) { js.executeScript("arguments[0].click();", premiumBtn); }
         
         Thread.sleep(5000);
         
         driver.findElement(Addon).click();
         Thread.sleep(5000);


    }
}