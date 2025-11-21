package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ExtentListener implements ITestListener {

    ExtentReports extent;
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

    @Override
    public void onStart(ITestContext context){
        ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Override
    public void onTestStart(ITestResult result){
        test.set(extent.createTest(result.getMethod().getMethodName()));
    }

    public static void TakingScreenshots(WebDriver driver, String Filename1,String Filename2) throws IOException, InterruptedException {
    
    	File capture1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File Screenshot1 = new File("C:\\Users\\user\\eclipse-workspace\\DittoWebPageProject\\test-output\\"+ Filename1 +".png");
    	FileHandler.copy(capture1,Screenshot1);
    	Thread.sleep(2000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0, 1000);");
    	Thread.sleep(2000);
    	File capture2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File Screenshot2 = new File("C:\\Users\\user\\eclipse-workspace\\DittoWebPageProject\\test-output\\"+ Filename2 +".png");
    	FileHandler.copy(capture2,Screenshot2);
    	Thread.sleep(5000);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        test.get().pass("Test Passed");
    }

    @Override
    public void onFinish(ITestContext context){
        extent.flush();
    }
}
