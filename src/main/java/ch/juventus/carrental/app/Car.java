package ch.juventus.carrental.app;

public class Car {
    private int id;
    private String name;
    private String type;
    private String gearShift;
    private int seats;
    private int pricePerDay;
    private Boolean airCondition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGearShift() {
        return gearShift;
    }

    public void setGearShift(String gearShift) {
        this.gearShift = gearShift;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Boolean getAirCondition() {
        return airCondition;
    }

    public void setAirCondition(Boolean airCondition) {
        this.airCondition = airCondition;
    }

    public Car(int id, String name, String type, String gearShift, int seats, int pricePerDay, Boolean airCondition) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.gearShift = gearShift;
        this.seats = seats;
        this.pricePerDay = pricePerDay;
        this.airCondition = airCondition;
    }

    public Car() {
    }

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

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", gearShift='" + gearShift + '\'' +
                ", seats=" + seats +
                ", pricePerDay=" + pricePerDay +
                ", airCondition=" + airCondition +
                '}';
    }
}