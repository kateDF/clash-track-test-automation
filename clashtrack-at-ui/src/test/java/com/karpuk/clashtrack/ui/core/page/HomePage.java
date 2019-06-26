package com.karpuk.clashtrack.ui.core.page;

import com.karpuk.clashtrack.ui.core.driver.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='start']//a[contains(@class,'btn-google')]")
    private WebElement signInWithGoogleButton;

    public void navigate(String url) {
        WebDriverManager.getInstance().get(url);
        logInfo("Open page " + url);
    }

    public void clickSignInWithGoogle() {
        signInWithGoogleButton.click();
    }

}
