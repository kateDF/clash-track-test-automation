package com.karpuk.clashtrack.ui.test.service;

import com.karpuk.clashtrack.ui.core.model.enums.TownHallLevelsEnum;

public class WarWeightCalculationService extends BaseService {

    public void calculateWarWeight(TownHallLevelsEnum townHallLevel, int storageNum, int goldAmount) {
        warWeightCalculatorPage.selectTownHallLevel(townHallLevel);
        warWeightCalculatorPage.selectGoldInStorage(storageNum, goldAmount);
        warWeightCalculatorPage.calculateWarWeight();
    }

}
