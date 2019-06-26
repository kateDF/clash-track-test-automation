package com.karpuk.clashtrack.ui.core.page;

import com.karpuk.clashtrack.ui.core.driver.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class BasePage {

    @PostConstruct
    public void initElements() {
        PageFactory.initElements(WebDriverManager.getInstance(), this);
    }

}
