package com.vehicles.demo.enums;

public enum Extra {
    AIR_CONDITIONING("Климатик"),
    CLIMATRONIC("Климатроник"),
    LEATHER_INTERIOR("Кожен салон"),
    GPS("GPS навигация"),
    SUNROOF("Шибидах"),
    XENON_LIGHTS("Ксенонови фарове"),
    PARKTRONIC("Парктроник"),
    ALARM("Аларма"),
    FOUR_BY_FOUR("4x4");

    private final String label;


    Extra(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
