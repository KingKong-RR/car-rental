package ch.juventus.carrental.app;

public class Car {
    private int id;
    private String name;
    private String type;
    private String gearShift;
    private int seats;
    private int pricePerDay;
    private Boolean airCondition;

    enum Type {
        CABRIO,
        LIMOUSINE,
        SUV,
        MINIBUS,
        COUPE,
        ESTATE
    }

    enum GearShift {
        MANUAL,
        AUTOMATIC
    }
}
