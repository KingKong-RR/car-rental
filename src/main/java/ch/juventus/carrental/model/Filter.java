package ch.juventus.carrental.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class Filter {
    private final Optional<String> startDate;
    private final Optional<String> endDate;
    private final Optional<String> query;
    private final Optional<CarType[]> types;
    private final Optional<Transmission> transmission;
    private final Optional<PriceRange> pricePerDayRange;
    private final Optional<Integer[]> seats;
    private final Optional<Boolean> airCondition;
    private final Optional<String> fuel; // ignoring fuel, its always null

    @JsonCreator
    public Filter(
            @JsonProperty("startDate") String startDate,
            @JsonProperty("endDate") String endDate,
            @JsonProperty("query") String query,
            @JsonProperty("types") CarType[] types,
            @JsonProperty("transmission") Transmission transmission,
            @JsonProperty("pricePerDay") PriceRange pricePerDayRange,
            @JsonProperty("seats") Integer[] seats,
            @JsonProperty("airCondition") Boolean airCondition,
            @JsonProperty("fuel") String fuel) {
        this.startDate = Optional.ofNullable(startDate);
        this.endDate = Optional.ofNullable(endDate);
        this.query = Optional.ofNullable(query);
        this.types = Optional.ofNullable(types);
        this.transmission = Optional.ofNullable(transmission);
        this.pricePerDayRange = Optional.ofNullable(pricePerDayRange);
        this.seats = Optional.ofNullable(seats);
        this.airCondition = Optional.ofNullable(airCondition);
        this.fuel = Optional.ofNullable(fuel); // ignoring fuel, its always null
    }

    @Override
    public String toString() {
        return "Filter{" +
                ", query=" + query +
                ", types=" + types +
                ", transmission=" + transmission +
                ", pricePerDayRange=" + pricePerDayRange +
                ", seats=" + seats +
                ", airCondition=" + airCondition +
                '}';
    }

    public Optional<String> getQuery() {
        return query;
    }

    public Optional<CarType[]> getTypes() {
        return types;
    }

    public Optional<Transmission> getTransmission() {
        return transmission;
    }

    public Optional<PriceRange> getPricePerDayRange() {
        return pricePerDayRange;
    }

    public Optional<Integer[]> getSeats() {
        return seats;
    }

    public Optional<Boolean> getAirCondition() {
        return airCondition;
    }
}
