package com.karpuk.clashtrack.ui.test;

import com.karpuk.clashtrack.ui.core.model.enums.TownHallLevelsEnum;
import com.karpuk.clashtrack.ui.test.base.BaseTestData;
import org.testng.annotations.Test;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;

public class BasesCollectionTest extends BaseTestData {

    @Test()
    void testBasesFilteringByTownHall() {
        logInfo("Verify Bases filtering by Town Hall level.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openBasesCollection();
        basesCollectionPage.selectTownHallLevel(TownHallLevelsEnum.TH9);
        softAssert.assertThat(basesCollectionPage.matchLevelsResults(TownHallLevelsEnum.TH9))
                .as("Verify filtering results").isTrue();
        softAssert.assertAll();
    }

}
