package ch.juventus.carrental.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceRange {
    private double min = 0;
    private double max = Double.MAX_VALUE;

    @JsonCreator
    public PriceRange(@JsonProperty("min") Double min,
                      @JsonProperty("max") Double max) {
        if (min != null) {
            this.min = min;
        }
        if (max != null) {
            this.max = max;
        }
    }

    @Override
    public String toString() {
        return "PriceRange{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }

    public boolean isValid(double value) {
        return value >= min && value <= max;
    }
}
