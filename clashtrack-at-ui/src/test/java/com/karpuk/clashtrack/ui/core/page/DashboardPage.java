package com.karpuk.clashtrack.ui.core.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;
import static com.karpuk.clashtrack.ui.core.util.Waiters.waitForVisibility;
import static com.karpuk.clashtrack.ui.core.util.Waiters.waitVisibilityAndClick;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//button[@id='right-menu']/span[@class='hidden-xs']")
    private WebElement currentUserNameTitle;

    @FindBy(xpath = "//button[@id='left-menu']")
    private WebElement leftMenuButton;

    @FindBy(xpath = "//li[@data-target='#tools-stuff-menu']/a")
    private WebElement toolsListButton;

    @FindBy(xpath = "//i[@class='fa fa-map-signs']/ancestor::a")
    private WebElement clashOfClansBasesButton;

    @FindBy(xpath = "//i[@class='fa fa-sliders']/ancestor::a")
    private WebElement troopCalculatorButton;

    @FindBy(xpath = "//i[@class='fa fa-balance-scale']/ancestor::a")
    private WebElement warWeightCalculatorButton;


    public String getCurrentUseName() {
        waitForVisibility(currentUserNameTitle);
        String currentUserName = currentUserNameTitle.getText();
        logInfo("Current user name: " + currentUserName);
        return currentUserName;
    }

    public void openBasesCollection() {
        openToolsList();
        logInfo("Open bases collection page");
        waitVisibilityAndClick(clashOfClansBasesButton);
    }

    public void openTroopCalculator() {
        openToolsList();
        logInfo("Open troop cost calculator");
        waitVisibilityAndClick(troopCalculatorButton);
    }

    public void openWarWeightCalculator() {
        openToolsList();
        logInfo("Open war weight calculator");
        waitVisibilityAndClick(warWeightCalculatorButton);
    }

    private void openToolsList() {
        logInfo("Open left menu");
        waitVisibilityAndClick(leftMenuButton);
        logInfo("Open tools");
        waitVisibilityAndClick(toolsListButton);
    }

}
