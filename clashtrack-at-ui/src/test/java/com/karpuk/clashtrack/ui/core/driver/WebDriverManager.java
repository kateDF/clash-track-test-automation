package com.karpuk.clashtrack.ui.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.karpuk.clashtrack.core.listener.TestListener.logError;

public class WebDriverManager {

    private static final String WEBDRIVER_CHROME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_FIREFOX = "webdriver.gecko.driver";

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public enum BrowserType {
        CHROME,
        FIREFOX,
    }

    public static WebDriver getInstance() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;
        switch (ConfigWebDriver.getBrowserType()) {
            case CHROME:
                System.setProperty(WEBDRIVER_CHROME, ConfigWebDriver.getDriverPath());
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty(WEBDRIVER_FIREFOX, ConfigWebDriver.getDriverPath());
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver();
                break;
        }
        maximize(driver);
        setImplicitlyWait(driver);
        setPageLoadTimeout(driver);
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver.get() != null) {
                driver.get().quit();
                driver.remove();
            }
        } catch (Exception e) {
            logError("Can not quit browser");
        }
    }

    private static void maximize(WebDriver driver) {
        if (ConfigWebDriver.isWindowMaximaze()) {
            driver.manage().window().maximize();
        }
    }

    private static void setImplicitlyWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(ConfigWebDriver.getImplicitlyWait(), TimeUnit.SECONDS);
    }

    private static void setPageLoadTimeout(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(ConfigWebDriver.getPageLoadTimeout(), TimeUnit.SECONDS);
    }

}
