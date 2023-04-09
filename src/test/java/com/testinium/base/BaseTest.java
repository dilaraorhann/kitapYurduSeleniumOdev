package com.testinium.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;

    @Before
    public void setup() {
        System.out.println("Selenium Egitimi");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe ");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("disable-notifications");
        chromeOptions.addArguments("start-maximized");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        chromeOptions.merge(caps);

        setDriver(new ChromeDriver(chromeOptions));
        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.kitapyurdu.com/");
    }

    @After
    public void tearDom() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BaseTest.driver = driver;
    }
}
