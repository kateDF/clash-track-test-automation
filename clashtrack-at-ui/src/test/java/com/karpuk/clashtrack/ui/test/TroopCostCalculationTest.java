package com.karpuk.clashtrack.ui.test;

import com.karpuk.clashtrack.ui.core.model.enums.BarracksTroopsEnum;
import com.karpuk.clashtrack.ui.core.model.enums.TownHallLevelsEnum;
import com.karpuk.clashtrack.ui.test.base.BaseTestData;
import org.testng.annotations.Test;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;

public class TroopCostCalculationTest extends BaseTestData {

    public static final int armyCapacity = 100;

    @Test()
    void testCalculateWithCorrectMaxArmyLightBarracks() {
        logInfo("Verify troops calculation with max army capacity in light barracks.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openTroopCalculator();
        troopCostCalculatorPage.selectTownHallLevel(TownHallLevelsEnum.TH2);
        troopCostCalculatorPage.selectArmyCapacity(armyCapacity);
        troopCostCalculatorPage.selectTroopsCapacityByTypes(BarracksTroopsEnum.BARBARIAN, armyCapacity);
        softAssert.assertThat(troopCostCalculatorPage.getAvailableQuantityOfLightBarracks())
                .as("Verify available quantity").isEqualTo(0);
        softAssert.assertAll();
    }

}
