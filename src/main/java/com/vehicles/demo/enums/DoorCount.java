package com.vehicles.demo.enums;

public enum DoorCount {
    TWO_THREE("2/3 врати"),
    FOUR_FIVE("4/5 врати");

    private final String label;

    DoorCount(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}