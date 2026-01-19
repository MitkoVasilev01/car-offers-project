package com.vehicles.demo.enums;

public enum Sort {
    NAME_ASCEDING("Марка-Възходящ"),
    NAME_DESCEDING("Марка-Низходящ"),
    PRICE_ASCEDING("Цена-Възходящ"),
    PRICE_DESCEDING("Цена-Низходящ"),
    DATE_MANUFACTURE_ASCEDING("Дата на производство-Възходящ"),
    DATE_MANUFACTURE_DESCEDING("Дата на производство-Низходящ"),
    MILEAGE_ASCEDING("Пробег-Възходящ"),
    MILEAGE_DESCEDING("Пробег-Низходящ");

    private final String label;


    Sort(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
