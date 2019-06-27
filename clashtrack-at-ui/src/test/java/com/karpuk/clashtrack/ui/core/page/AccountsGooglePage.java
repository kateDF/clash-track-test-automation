package com.karpuk.clashtrack.ui.core.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;
import static com.karpuk.clashtrack.ui.core.util.Waiters.waitForVisibility;

public class AccountsGooglePage extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement nextToPasswordButton;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement nextToSignInButton;

    public void enterEmail(String email) {
        logInfo("SingIn with email: " + email);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        waitForVisibility(passwordInput);
        passwordInput.sendKeys(password);
    }

    public void clickNextToPassword() {
        nextToPasswordButton.click();
    }

    public void clickNextToSignIn() {
        nextToSignInButton.click();
    }

}
