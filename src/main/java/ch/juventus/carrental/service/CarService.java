package ch.juventus.carrental.service;

import ch.juventus.carrental.app.Car;
import ch.juventus.carrental.model.Filter;
import ch.juventus.carrental.persistance.Database;
import ch.juventus.carrental.persistance.FileDatabase;
import ch.juventus.carrental.util.FilterEvaluator;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final Database database;
    private String id;
    private Car car;

    public CarService(FileDatabase fileDatabase) {
        this.database = fileDatabase;
    }

    public String getStatus() {
        return database.getStatus();
    }

    public ArrayList<Car> getAllCars() {
        return database.getAllCars();
    }

    public Car getCarById(Long id) {
        return database.getCarById(id);
    }

    public String addCar(Car car) {
        return database.addCar(car);
    }

    public String deleteCarById(Long id) throws IOException {
        return database.deleteCarById(id);
    }
}
