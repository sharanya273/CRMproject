package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.crm.qa.actiondriver.Action;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.ietf.jgss.Oid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


import com.beust.jcommander.Parameter;


import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Hitendra: BaseClass is used to load the config file and Initialize
 * WebDriver
 */
public class BaseClass {


    public static Properties prop;
    private static WebDriver driver;


    static {
       PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "config" +File.separator+ "log4j.properties");
    }

    final static Logger log = Logger.getLogger(BaseClass.class);


    // Declare ThreadLocal Driver


    //loadConfig method is to load the configuration

    @BeforeTest
    public void loadConfig() {

//        DOMConfigurator.configure("log4j.xml");
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + File.separator + "config" +File.separator+ "config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static WebDriver getDriver() {
        // Get Driver from threadLocalmap
        return driver;
    }

    public static void launchApp() {
        Action action = new Action();
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
            // driver=new HtmlUnitDriver();
        } else if (browserName.equals("FF")) {
            driver = new FirefoxDriver();
        }
        getDriver().manage().window().maximize();
        action.implicitWait(getDriver(), 30);
        action.pageLoadTimeOut(getDriver(), 30);
        getDriver().get(prop.getProperty("url"));

    }




}
