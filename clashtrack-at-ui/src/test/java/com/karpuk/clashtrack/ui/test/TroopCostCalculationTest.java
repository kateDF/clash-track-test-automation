package com.karpuk.clashtrack.ui.test;

import com.karpuk.clashtrack.ui.core.model.enums.LightBarracksTroopsEnum;
import com.karpuk.clashtrack.ui.core.model.enums.TownHallLevelsEnum;
import com.karpuk.clashtrack.ui.test.base.BaseTestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;

public class TroopCostCalculationTest extends BaseTestData {

    @DataProvider(name = "data-provider-light-barracks")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{100, TownHallLevelsEnum.TH3, LightBarracksTroopsEnum.BARBARIAN, 100, LightBarracksTroopsEnum.BARBARIAN.getArmySpace() * 100},
                {150, TownHallLevelsEnum.TH7, LightBarracksTroopsEnum.BALLOON, 5, LightBarracksTroopsEnum.BALLOON.getArmySpace() * 5},
                {200, TownHallLevelsEnum.TH9, LightBarracksTroopsEnum.DRAGON, 30, LightBarracksTroopsEnum.DRAGON.getArmySpace() * 30}
        };
    }

    @Test(dataProvider = "data-provider-light-barracks")
    void testCalculateQuantityLightBarracks(int armyCapacity, TownHallLevelsEnum townHallLevels, LightBarracksTroopsEnum troopType, int quantity, int capacityExecuting) {
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
