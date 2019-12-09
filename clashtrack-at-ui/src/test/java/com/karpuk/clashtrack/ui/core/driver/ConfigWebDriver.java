package com.karpuk.clashtrack.ui.core.driver;

import java.util.ResourceBundle;

public class ConfigWebDriver {
    private static final ResourceBundle bundle = ResourceBundle.getBundle(System.getProperty("env"));

    public static WebDriverManager.BrowserType getBrowserType() {
        return WebDriverManager.BrowserType.valueOf(bundle.getString("driver.browser").toUpperCase());
    }

    public static String getDriverPath() {
        return bundle.getString("driver.path");
    }

    public static boolean isWindowMaximaze() {
        return Boolean.parseBoolean(bundle.getString("driver.windowMaximize"));
    }

    public static Long getImplicitlyWait() {
        return Long.parseLong(bundle.getString("driver.implicitlyWait"));
    }

    public static Long getPageLoadTimeout() {
        return Long.parseLong(bundle.getString("driver.pageLoadTimeout"));
    }

}
