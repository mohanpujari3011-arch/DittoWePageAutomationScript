package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class PremiumPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PremiumPage(WebDriver d){
        this.driver = d;
        this.wait = new WebDriverWait(d, Duration.ofSeconds(20));
    }

    private By nextButton = By.xpath("//span[normalize-space()='Next']");
    private By continueButton = By.xpath("//span[contains(text(),'Continue')]");

    public void clickNextButtons(int count) throws InterruptedException {

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 500);");

        for (int i = 0; i < count; i++) {

            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
      
            js.executeScript("arguments[0].scrollIntoView(true);", btn);

            try {
                btn.click();
            } catch (Exception e) {
                js.executeScript("arguments[0].click();", btn);
            }
           
            Thread.sleep(1000);
        } 
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(continueButton).click(); 
        Thread.sleep(5000);
       
    }
}