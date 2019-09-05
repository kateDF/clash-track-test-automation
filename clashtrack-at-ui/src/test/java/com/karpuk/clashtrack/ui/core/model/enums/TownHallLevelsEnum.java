package com.karpuk.clashtrack.ui.core.model.enums;

public enum TownHallLevelsEnum {

    ALL(0),
    TH1(1),
    TH2(2),
    TH3(3),
    TH4(4),
    TH5(5),
    TH6(6),
    TH7(7),
    TH8(8),
    TH9(9),
    TH10(10),
    TH11(11),
    TH12(12);

    private int value;

    TownHallLevelsEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
