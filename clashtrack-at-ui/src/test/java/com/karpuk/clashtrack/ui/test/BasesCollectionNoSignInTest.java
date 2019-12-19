package com.karpuk.clashtrack.ui.test;

import com.karpuk.clashtrack.ui.core.model.enums.TownHallLevelsEnum;
import com.karpuk.clashtrack.ui.test.base.BaseTestData;
import org.testng.annotations.Test;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;

public class BasesCollectionNoSignInTest extends BaseTestData {

    @Test()
    void testBasesFilteringByTownHall() {
        logInfo("Verify Bases filtering by Town Hall level.");
        homePage.navigate(baseUrl);
        dashboardPage.openBasesCollection();
        basesCollectionPage.selectTownHallLevel(TownHallLevelsEnum.TH9);
        softAssert.assertThat(basesCollectionPage.matchLevelsResults(TownHallLevelsEnum.TH9))
                .as("Verify filtering results").isTrue();
        softAssert.assertAll();
    }

    @Test()
    void testOpenExactLevelBase() {
        logInfo("Verify level of chosen base layout page.");
        homePage.navigate(baseUrl);
        dashboardPage.openBasesCollection();
        basesCollectionPage.selectTownHallLevel(TownHallLevelsEnum.TH7);
        basesCollectionPage.openFirstBaseLayout();
        softAssert.assertThat(baseLayoutPage.getTHLevel())
                .as("Verify town hall level").isEqualToIgnoringCase(TownHallLevelsEnum.TH7.toString());
        softAssert.assertAll();
    }

    @Test()
    void testReturnToListFromExactBase() {
        logInfo("Verify returning to List of Bases.");
        homePage.navigate(baseUrl);
        dashboardPage.openBasesCollection();
        basesCollectionPage.openFirstBaseLayout();
        baseLayoutPage.backToBasesList();
        softAssert.assertThat(basesCollectionPage.getSectionTitle())
                .as("Verify section title").isEqualTo("List of Clash of clans bases");
        softAssert.assertAll();
    }

    @Test()
    void testCheckTypeOfExactBase() {
        logInfo("Verify base type.");
        homePage.navigate(baseUrl);
        dashboardPage.openBasesCollection();
        String firstBaseType = basesCollectionPage.getFirstBaseType();
        basesCollectionPage.openFirstBaseLayout();
        softAssert.assertThat(baseLayoutPage.getBaseType())
                .as("Verify type of base").isSubstringOf(firstBaseType);
        softAssert.assertAll();
    }

    @Test()
    void testCheckLevelProposedBases() {
        logInfo("Verify level of chosen base layout page.");
        homePage.navigate(baseUrl);
        dashboardPage.openBasesCollection();
        basesCollectionPage.selectTownHallLevel(TownHallLevelsEnum.TH6);
        basesCollectionPage.openFirstBaseLayout();
        softAssert.assertThat(baseLayoutPage.matchLevelsOfProposedBases(TownHallLevelsEnum.TH6))
                .as("Verify levels").isTrue();
        softAssert.assertAll();
    }

}
