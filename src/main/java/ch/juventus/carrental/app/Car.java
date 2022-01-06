package ch.juventus.carrental.app;

import ch.juventus.carrental.model.CarType;
import ch.juventus.carrental.model.Transmission;

import java.util.Random;

public class Car {
    private Long id = Math.abs(new Random().longs(1,1,9999999).iterator().nextLong());
    private String name;
    private CarType type;
    private Transmission transmission;
    private int seats;
    private int pricePerDay;
    private Boolean airCondition;

    public Car(Long id, String name, CarType type, Transmission transmission, int seats, int pricePerDay, Boolean airCondition) {
        if (id != null) {
            this.id = id;
        }
        this.name = name;
        this.type = type;
        this.transmission = transmission;
        this.seats = seats;
        this.pricePerDay = pricePerDay;
        this.airCondition = airCondition;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
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

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", transmission='" + transmission + '\'' +
                ", seats=" + seats +
                ", pricePerDay=" + pricePerDay +
                ", airCondition=" + airCondition +
                '}';
    }
}
