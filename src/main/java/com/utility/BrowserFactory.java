package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by tolaf on 29/04/2018.
 * Using Spring to build Automation Framework
 * Objective: Initialize WebDriver
 */

@Component
public class BrowserFactory {

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String IEXPLORER ="ie";

    @Value("${os.name}")
    private String osName;
    @Value("${browser.name}")
    private String browserName;
    private WebDriver webDriver;

    public BrowserUtils create() {
        WebDriver webDriver = getWebDriver();
        if (webDriver == null) {
            throw new IllegalArgumentException("Webdriver is not supported: "+browserName);
        }
        return new BrowserUtils(webDriver);
    }

    private WebDriver getWebDriver() {

        //check OS then set folder
        String driverFolder="";
        if (osName.matches("Windows.*"))
            driverFolder="src/test/java/drivers";
        else
            throw new UnsupportedOperationException("Operating System is not supported");

        //Load browser driver
        if (browserName.equals(CHROME)) {
            System.setProperty("webdriver.chrome.driver", driverFolder.concat("/chromedriver"));
            webDriver = new ChromeDriver();
        }
        else if (browserName.equals(FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", driverFolder.concat("/geckodriver"));
            webDriver= new FirefoxDriver();
        }
        else if (browserName.equals(IEXPLORER)) {
            System.setProperty("webriver.ie.driver", driverFolder.concat("/IEDriverServer"));
            webDriver=new InternetExplorerDriver();
        }
        else {
            throw new UnsupportedOperationException("Browser is not supported");
        }

        // to maximize the browser window
        webDriver.manage().window().maximize();

        return webDriver;
    }

}