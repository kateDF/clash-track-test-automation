package com.karpuk.clashtrack.ui.test;

import com.karpuk.clashtrack.ui.test.base.BaseTestData;
import org.testng.annotations.Test;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;

public class SignInTest extends BaseTestData {

    @Test()
    void testSuccessSignInWithGoogleAccount() {
        logInfo("Verify success sign in with google account.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        softAssert.assertThat(dashboardPage.getCurrentUseName())
                .as("Verify Account Name")
                .isNotEqualToIgnoringCase(user.getName());
        softAssert.assertAll();
    }

}
