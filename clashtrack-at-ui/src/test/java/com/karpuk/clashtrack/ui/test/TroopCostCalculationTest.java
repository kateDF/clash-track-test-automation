package com.karpuk.clashtrack.ui.test;

import com.karpuk.clashtrack.ui.core.model.enums.LightBarracksTroopsEnum;
import com.karpuk.clashtrack.ui.core.model.enums.TownHallLevelsEnum;
import com.karpuk.clashtrack.ui.test.base.BaseTestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;

public class TroopCostCalculationTest extends BaseTestData {

    @DataProvider(name = "data-provider-light-barracks")
    public Object[][] dataProviderLightBarracks() {
        return new Object[][]{{100, TownHallLevelsEnum.TH3, LightBarracksTroopsEnum.BARBARIAN, 100, LightBarracksTroopsEnum.BARBARIAN.getArmySpace() * 100},
                {150, TownHallLevelsEnum.TH7, LightBarracksTroopsEnum.BALLOON, 5, LightBarracksTroopsEnum.BALLOON.getArmySpace() * 5},
                {200, TownHallLevelsEnum.TH9, LightBarracksTroopsEnum.DRAGON, 30, LightBarracksTroopsEnum.DRAGON.getArmySpace() * 30}
        };
    }

    @DataProvider(name = "data-provider-exceeded-capacity-light-barracks")
    public Object[][] dataProviderExceededCapacity() {
        return new Object[][]{{200, TownHallLevelsEnum.TH10, LightBarracksTroopsEnum.P_E_K_K_A, 30, LightBarracksTroopsEnum.P_E_K_K_A.getArmySpace() * 30},
                {200, TownHallLevelsEnum.TH9, LightBarracksTroopsEnum.BABY_DRAGON, 25, LightBarracksTroopsEnum.BABY_DRAGON.getArmySpace() * 25}
        };
    }

    @Test(dataProvider = "data-provider-light-barracks")
    void testCalculateQuantityLightBarracks(int armyCapacity, TownHallLevelsEnum townHallLevel, LightBarracksTroopsEnum troopType, int quantity, int capacityExecuting) {
        logInfo("Verify troops calculation in light barracks.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openTroopCalculator();
        troopCalculationService.selectTroopsInLightBarracksCalculator(armyCapacity, townHallLevel, troopType, quantity);
        softAssert.assertThat(troopCostCalculatorPage.getAvailableQuantityOfLightBarracks())
                .as("Verify available quantity").isEqualTo(armyCapacity - capacityExecuting);
        softAssert.assertAll();
    }

    @Test(dataProvider = "data-provider-exceeded-capacity-light-barracks")
    void testExceededCapacityLightBarracks(int armyCapacity, TownHallLevelsEnum townHallLevel, LightBarracksTroopsEnum troopType, int quantity, int capacityExecuting) {
        logInfo("Verify error message with exceeded capacity in Light Barracks.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openTroopCalculator();
        troopCalculationService.selectTroopsInLightBarracksCalculator(armyCapacity, townHallLevel, troopType, quantity);
        softAssert.assertThat(troopCostCalculatorPage.getErrorMessageLightBarracks())
                .as("Verify error message in Light Barracks calculator").contains("Exceeded training capacity of the Barracks");
        softAssert.assertAll();
    }

    @Test(dataProvider = "data-provider-light-barracks")
    void testResetQuantityLightBarracks(int armyCapacity, TownHallLevelsEnum townHallLevel, LightBarracksTroopsEnum troopType, int quantity, int capacityExecuting) {
        logInfo("Verify result of quantity reset in Light Barracks.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openTroopCalculator();
        troopCalculationService.selectTroopsInLightBarracksCalculator(armyCapacity, townHallLevel, troopType, quantity);
        troopCostCalculatorPage.resetQuantityInLightBarracks();
        softAssert.assertThat(troopCostCalculatorPage.getAvailableQuantityOfLightBarracks())
                .as("Verify quantity reset in Light Barracks").isEqualTo(armyCapacity);
        softAssert.assertAll();
    }

    @Test(dataProvider = "data-provider-light-barracks")
    void testSaveArmyCompositionLightBarracks(int armyCapacity, TownHallLevelsEnum townHallLevel, LightBarracksTroopsEnum troopType, int quantity, int capacityExecuting) {
        logInfo("Verify saving of the army composition.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openTroopCalculator();
        troopCalculationService.selectTroopsInLightBarracksCalculator(armyCapacity, townHallLevel, troopType, quantity);
        troopCostCalculatorPage.saveArmyComposition();
        softAssert.assertThat(troopCostCalculatorPage.getSavedCompositionCapacity())
                .as("Verify saved composition capacity").contains(troopCostCalculatorPage.getCapacityResultInLightBarracks());
        softAssert.assertAll();
    }

    @Test(dataProvider = "data-provider-light-barracks")
    void testLoadArmyCompositionLightBarracks(int armyCapacity, TownHallLevelsEnum townHallLevel, LightBarracksTroopsEnum troopType, int quantity, int capacityExecuting) {
        logInfo("Verify loading of the saved army composition.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openTroopCalculator();
        troopCalculationService.selectTroopsInLightBarracksCalculator(armyCapacity, townHallLevel, troopType, quantity);
        troopCostCalculatorPage.saveArmyComposition();
        troopCostCalculatorPage.resetQuantityInLightBarracks();
        troopCostCalculatorPage.loadArmyComposition();
        softAssert.assertThat(troopCostCalculatorPage.getCapacityResultInLightBarracks())
                .as("Verify capacity in loaded army").contains(troopCostCalculatorPage.getSavedCompositionCapacity());
        softAssert.assertAll();
    }

    @Test
    void testOpenHelpToolTip() {
        logInfo("Verify opening of help tooltip.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openTroopCalculator();
        troopCostCalculatorPage.openFirstHelpToolTip();
        softAssert.assertThat(troopCostCalculatorPage.isHelpToolTipPresented())
                .as("Verify help tooltip presence").isTrue();
        softAssert.assertAll();
    }

    @Test
    void testCloseHelpToolTip() {
        logInfo("Verify closing of help tooltip.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openTroopCalculator();
        troopCostCalculatorPage.openFirstHelpToolTip();
        troopCostCalculatorPage.closeHelpToolTip();
        softAssert.assertThat(troopCostCalculatorPage.isHelpToolTipPresented())
                .as("Verify help tooltip presence").isFalse();
        softAssert.assertAll();
    }

    @Test
    void testOpenSaveArmyHelpToolTip() {
        logInfo("Verify save army help tool tip text.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openTroopCalculator();
        troopCostCalculatorPage.openSaveArmyHelpToolTip();
        softAssert.assertThat(troopCostCalculatorPage.getFirstHelpToolTipPresented())
                .as("Verify help tooltip text").contains("You can save your army compositions for future use");
        softAssert.assertAll();
    }

}
