package com.karpuk.clashtrack.ui.test;

import com.karpuk.clashtrack.ui.core.model.enums.BarracksTroopsEnum;
import com.karpuk.clashtrack.ui.core.model.enums.TownHallLevelsEnum;
import com.karpuk.clashtrack.ui.test.base.BaseTestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;

public class TroopCostCalculationTest extends BaseTestData {

    @DataProvider(name = "data-provider-light-barracks")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { 100, TownHallLevelsEnum.TH2, BarracksTroopsEnum.BARBARIAN, 100, 100 },
                { 150, TownHallLevelsEnum.TH3,BarracksTroopsEnum.ARCHER, 5, 5},
                { 200, TownHallLevelsEnum.TH6, BarracksTroopsEnum.BALLOON, 100, 500},};
    }

    @Test(dataProvider = "data-provider-light-barracks")
    void testCalculateQuantityLightBarracks(int armyCapacity, TownHallLevelsEnum townHallLevels, BarracksTroopsEnum troopType, int quantity, int capacityExecuting) {
        logInfo("Verify troops calculation with max army capacity in light barracks.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openTroopCalculator();
        troopCostCalculatorPage.selectTownHallLevel(townHallLevels);
        troopCostCalculatorPage.selectArmyCapacity(armyCapacity);
        troopCostCalculatorPage.selectTroopsCapacityByTypes(troopType, quantity);
        softAssert.assertThat(troopCostCalculatorPage.getAvailableQuantityOfLightBarracks())
                .as("Verify available quantity").isEqualTo(armyCapacity - capacityExecuting);
        softAssert.assertAll();
    }

}
