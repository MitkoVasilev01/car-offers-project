package com.vehicles.demo.enums;

public enum Engine {
   GASOLINE("Бензин"),
    DIESEL("Дизел"),
    ELECTRIC("Eлектрически"),
    HYBRID("Хибриден");

    private final String label;

    Engine(String label) {
       this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

