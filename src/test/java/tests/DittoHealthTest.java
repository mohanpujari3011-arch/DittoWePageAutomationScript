package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;
import utils.ExtentListener;

public class DittoHealthTest extends BaseTest {
    @Test
    public void verifyPremiumCalculation() throws Exception {
        driver.get("https://app.joinditto.in/fq");
        Thread.sleep(5000);

        HomePage h=new HomePage(driver);
        h.selectHealthCategory();
        PremiumPage premium = new PremiumPage(driver);
        premium.clickNextButtons(3);
        Thread.sleep(5000);
        TellAboutYouPage f=new TellAboutYouPage(driver);
        f.fillForm(25,515122);
        ValidationPage vp = new ValidationPage(driver);
        vp.validatePremium();
        ExtentListener.TakingScreenshots(driver, "Screenshot1","Screenshot2");
        
        Thread.sleep(3000);

    }
}
