package com.karpuk.clashtrack.ui.core.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;
import static com.karpuk.clashtrack.ui.core.util.Waiters.waitForVisibility;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//button[@id='right-menu']/span[@class='hidden-xs']")
    private WebElement currentUserNameTitle;

    public String getCurrentUseName() {
        waitForVisibility(currentUserNameTitle);
        String currentUserName = currentUserNameTitle.getText();
        logInfo("Current user name: " + currentUserName);
        return currentUserName;
    }

}
