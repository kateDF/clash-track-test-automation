package com.karpuk.clashtrack.ui.test;

import com.karpuk.clashtrack.ui.core.model.enums.TownHallLevelsEnum;
import com.karpuk.clashtrack.ui.test.base.BaseTestData;
import org.assertj.core.data.Percentage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;

public class WarWeightCalculationTest extends BaseTestData {


    @DataProvider(name = "data-provider-same-gold-amоunt")
    public Object[][] dataSameGoldAmount() {
        return new Object[][]{{TownHallLevelsEnum.TH8, 100000},
                {TownHallLevelsEnum.TH10, 1111111111},
                {TownHallLevelsEnum.TH5, 222}
        };
    }

    @Test(dataProvider = "data-provider-same-gold-amоunt")
    void testCalculatedWithSameStorage(TownHallLevelsEnum townHallLevel, int goldAmount) {
        logInfo("Verify calculation with the same amount of gold in storage.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openWarWeightCalculator();
        warWeightCalculatorPage.selectTownHallLevel(townHallLevel);
        warWeightCalculatorPage.selectGoldInStorage(1, goldAmount);
        warWeightCalculatorPage.calculateWarWeight();
        softAssert.assertThat(warWeightCalculatorPage.getCalculatedWarWeight())
                .as("Verify calculated war weight").isCloseTo(Math.ceil((double) goldAmount * (warWeightCalculatorPage.getNumberOfStorage() + 1) / 1000), Percentage.withPercentage(1));
        softAssert.assertAll();
    }

}
