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
    FOUR_BY_FOUR("4x4"),
    GAS("Газова уредба"),
    ABS("Автоматичен контрол на стабилността"),
    AIRBAG_FRONT("Въздушни възглавници - предни"),
    AIRBAG_REAR("Въздушни възглавници - задни"),
    AIRBAG_SIDES("Въздушни възглавници - странични"),
    ESP("Eлектронна програма за стабилност"),
    ONBOARD_COMPUTER("Бордкомпютър"),
    ELECTRONIC_MIRRORS("Ел. огледала"),
    ELECTRONIC_GLASSES("Ел. Стъкла"),
    MULTIFUNCTIONAL_STEERING_WHEEL("Мултифункционален волан"),
    SEAT_HEATING("Подгряване на седалките"),
    AUTO_PILOT("Автопилот"),
    AUDIO_SYSTEM("Аудио система"),
    SEVEN_SEATS("7 места"),
    NEW_IMPORT("Нов внос"),
    REGISTERED("С регистрация"),
    LED_LIGHTS("LED фарове"),
    RIGHT_STEERING_WHEEL("Десен волан");




    private final String label;


    Extra(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
