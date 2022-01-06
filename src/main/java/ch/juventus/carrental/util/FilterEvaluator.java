package ch.juventus.carrental.util;

import ch.juventus.carrental.app.Car;
import ch.juventus.carrental.model.Filter;

import java.util.Arrays;
import java.util.Optional;

import static java.lang.reflect.Array.getLength;

public class FilterEvaluator {
    private final Filter filter;

    public FilterEvaluator(Filter filter) {
        this.filter = filter;
    }

    public boolean passesAllFilters(Car car) {
        return passesQueryFilter(car) &&
                passesTypeFilter(car) &&
                passesTransmissionFilter(car) &&
                passesPricePerDayFilter(car) &&
                passesSeatsFilter(car) &&
                passesAirConditionFilter(car);
    }

    private boolean passesQueryFilter(Car car) {
        if (isNotApplicable(filter.getQuery())) return true;
        return car.getName().toLowerCase()
                .contains(filter.getQuery().get().toLowerCase());
    }

    private boolean passesTypeFilter(Car car) {
        if (isNotApplicable(filter.getTypes())) return true;
        return Arrays.asList(filter.getTypes().get()).contains(car.getType());
    }

    private boolean passesTransmissionFilter(Car car) {
        if (isNotApplicable(filter.getTransmission())) return true;
        return car.getTransmission() == filter.getTransmission().get();
    }

    private boolean passesPricePerDayFilter(Car car) {
        if (isNotApplicable(filter.getPricePerDayRange())) return true;
        return filter.getPricePerDayRange().get().isValid(car.getPricePerDay());
    }

    private boolean passesSeatsFilter(Car car) {
        if (isNotApplicable(filter.getSeats())) return true;
        return Arrays.asList(filter.getSeats().get()).contains(car.getSeats());
    }

    private boolean passesAirConditionFilter(Car car) {
        if (isNotApplicable(filter.getAirCondition())) return true;
        return car.getAirCondition() == filter.getAirCondition().get();
    }

    private <T> boolean isNotApplicable(Optional<T> filter) {
        if (filter.isPresent()) {
            if (filter.get().getClass().isArray()) {
                return getLength(filter.get()) <= 0;
            }
            if (filter.get() instanceof String) {
                return ((String) filter.get()).isEmpty();
            }
            return false;
        }
        return true;
    }
}
