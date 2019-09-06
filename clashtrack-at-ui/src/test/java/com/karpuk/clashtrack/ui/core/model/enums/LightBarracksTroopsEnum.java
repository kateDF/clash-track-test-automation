package com.karpuk.clashtrack.ui.core.model.enums;

public enum LightBarracksTroopsEnum {

    BARBARIAN("Barbarian", 1),
    ARCHER("Archer", 1),
    GIANT("Giant", 5),
    GOBLIN("Goblin", 1),
    WALL_BREAKER("Wall_Breaker", 2),
    BALLOON("Balloon", 5),
    WIZARD("Wizard", 4),
    HEALER("Healer", 14),
    DRAGON("Dragon", 20),
    P_E_K_K_A("P-E-K-K-A-", 25),
    BABY_DRAGON("BabyDragon", 10),
    MINER("Miner", 6);

    private String troopType;
    private int armySpace;

    LightBarracksTroopsEnum(String troopType, int armySpace) {
        this.troopType = troopType;
        this.armySpace = armySpace;
    }

    public String getTroopType() {
        return this.troopType;
    }

    public int getArmySpace() {
        return this.armySpace;
    }

}
