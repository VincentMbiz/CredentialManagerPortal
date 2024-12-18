package com.safetrust.common;

import com.safetrust.constant.ConstantGlobal;
import com.safetrust.drivers.DriverManager;
import com.safetrust.helpers.PropertiesHelper;
import com.safetrust.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTest {

    public static void createDriver(String browser) {
        if (DriverManager.getDriver()==null){
            WebDriver driver = setupDriver(browser);
            PropertiesHelper.loadAllFiles();
            //Set giá trị driver đã đc khởi tạo vào ThreadLocal
            DriverManager.setDriver(driver);
        }
    }

    public static void createDriver() {
        if (DriverManager.getDriver()==null){
            WebDriver driver = setupDriver("chrome");
            PropertiesHelper.loadAllFiles();
            //Set giá trị driver đã đc khởi tạo vào ThreadLocal
            DriverManager.setDriver(driver);
        }
    }

    public static WebDriver setupDriver(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private static WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        //WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        if(ConstantGlobal.HEADLESS == true){
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        //WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        if(ConstantGlobal.HEADLESS == true){
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        //WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        FirefoxOptions options = new FirefoxOptions();
        if(ConstantGlobal.HEADLESS == true){
            options.addArguments("--headless");
            options.addArguments("window-size=1800,900");
        }
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }

}
