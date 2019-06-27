package com.karpuk.clashtrack.ui.test.service;

import com.karpuk.clashtrack.ui.core.model.User;

public class SignInService extends BaseService {

    public void signInWithGoogleAccount(User user) {
        homePage.clickSignInWithGoogle();
        accountsGooglePage.enterEmail(user.getEmail());
        accountsGooglePage.clickNextToPassword();
        accountsGooglePage.enterPassword(user.getPassword());
        accountsGooglePage.clickNextToSignIn();
    }

}
