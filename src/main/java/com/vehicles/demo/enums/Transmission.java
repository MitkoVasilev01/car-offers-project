package com.vehicles.demo.enums;

public enum Transmission {
    AUTOMATIC("Aвтоматична"),
    MANUAL("Ръчна"),
    SEMI_AUTOMATIC("Полуавтоматична");

    private final String label;

    Transmission(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
