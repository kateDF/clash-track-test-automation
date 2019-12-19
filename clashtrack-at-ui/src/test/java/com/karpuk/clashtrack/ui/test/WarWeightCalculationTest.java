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
                {TownHallLevelsEnum.TH10, 11111111},
                {TownHallLevelsEnum.TH5, 222}
        };
    }

    @Test(dataProvider = "data-provider-same-gold-amоunt")
    void testCalculatedWithSameStorage(TownHallLevelsEnum townHallLevel, int goldAmount) {
        logInfo("Verify calculation with the same amount of gold in storage.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openWarWeightCalculator();
        warWeightCalculationService.calculateWarWeight(townHallLevel, 1, goldAmount);
        softAssert.assertThat((double) warWeightCalculatorPage.getCalculatedWarWeight())
                .as("Verify calculated war weight").isCloseTo(Math.ceil((double) goldAmount * (warWeightCalculatorPage.getNumberOfStorage() + 1) / 1000), Percentage.withPercentage(1));
        softAssert.assertAll();
    }

    @Test(dataProvider = "data-provider-same-gold-amоunt")
    void testCalculatedIncreaseGold(TownHallLevelsEnum townHallLevel, int goldAmount) {
        logInfo("Verify changing of war weight with increasing gold in storage.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openWarWeightCalculator();
        warWeightCalculationService.calculateWarWeight(townHallLevel, 1, goldAmount);
        int goldWithFirstAmount = warWeightCalculatorPage.getCalculatedWarWeight();
        warWeightCalculatorPage.selectGoldInStorage(1, goldAmount * 2);
        softAssert.assertThat(goldWithFirstAmount)
                .as("Verify war weight changing").isLessThanOrEqualTo(warWeightCalculatorPage.getCalculatedWarWeight());
        softAssert.assertAll();
    }

    @Test(dataProvider = "data-provider-same-gold-amоunt")
    void testCalculatedDecreaseGold(TownHallLevelsEnum townHallLevel, int goldAmount) {
        logInfo("Verify changing of war weight with decreasing gold in storage.");
        homePage.navigate(baseUrl);
        signInService.signInWithGoogleAccount(user);
        dashboardPage.openWarWeightCalculator();
        warWeightCalculationService.calculateWarWeight(townHallLevel, 1, goldAmount);
        int goldWithFirstAmount = warWeightCalculatorPage.getCalculatedWarWeight();
        warWeightCalculatorPage.selectGoldInStorage(1, goldAmount / 2);
        softAssert.assertThat(goldWithFirstAmount)
                .as("Verify war weight changing").isGreaterThanOrEqualTo(warWeightCalculatorPage.getCalculatedWarWeight());
        softAssert.assertAll();
    }

}
