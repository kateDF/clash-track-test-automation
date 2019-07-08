package com.karpuk.clashtrack.ui.core.util;

import com.karpuk.clashtrack.ui.core.driver.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {

    public static void waitForVisibility(WebElement element) {
        new WebDriverWait(WebDriverManager.getInstance(), 10)
                .until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static void waitVisibilityAndClick(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

}
