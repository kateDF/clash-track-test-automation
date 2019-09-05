package com.karpuk.clashtrack.ui.core.model.enums;

public enum BarracksTroopsEnum {

    BARBARIAN(1),
    ARCHER(1),
    GIANT(5),
    GOBLIN(1),
    WALL_BREAKER(2),
    BALLON(5),
    WIZARD(4),
    HEALER(14),
    DRAGON(20),
    P_E_K_K_A_(25),
    BABYDRAGON(12),
    MINER(6);

    private int armySpace;

    BarracksTroopsEnum(int armySpace) {
        this.armySpace = armySpace;
    }

    public int getArmySpace() {
        return this.armySpace;
    }

}
