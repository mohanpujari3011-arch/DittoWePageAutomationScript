package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if(tl.get()==null){
            tl.set(new ChromeDriver());
            tl.get().manage().window().maximize();
        }
        return tl.get();
    }

    public static void quitDriver(){
        if(tl.get()!=null){
            tl.get().quit();
            tl.remove();
        }
    }
}
