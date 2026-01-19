package com.vehicles.demo.enums;

public enum Color {
    BLACK("Черен"),
    WHITE("Бял"),
    SILVER("Сребрист"),
    GRAY("Сив"),
    BLUE("Син"),
    RED("Червен"),
    GREEN("Зелен"),
    BROWN("Кафяв"),
    BEIGE("Бежов"),
    YELLOW("Жълт"),
    ORANGE("Оранжев"),
    PURPLE("Лилав"),
    GOLD("Златист"),
    CHAMELEON("Хамелеон"),
    OTHER("Друг");

    private final String label;

    Color(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

