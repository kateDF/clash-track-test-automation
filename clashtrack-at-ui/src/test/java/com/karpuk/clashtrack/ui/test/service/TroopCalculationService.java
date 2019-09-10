package com.karpuk.clashtrack.ui.test.service;

import com.karpuk.clashtrack.ui.core.model.enums.LightBarracksTroopsEnum;
import com.karpuk.clashtrack.ui.core.model.enums.TownHallLevelsEnum;

public class TroopCalculationService extends BaseService {

    public void selectTroopsInLightBarracksCalculator(int armyCapacity, TownHallLevelsEnum townHallLevels, LightBarracksTroopsEnum troopType, int quantity) {
        troopCostCalculatorPage.selectTownHallLevel(townHallLevels);
        troopCostCalculatorPage.selectArmyCapacity(armyCapacity);
        troopCostCalculatorPage.selectTroopsCapacityByTypes(troopType, quantity);
    }

}
