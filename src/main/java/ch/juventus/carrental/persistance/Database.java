package ch.juventus.carrental.persistance;

import ch.juventus.carrental.app.Car;

import java.io.IOException;
import java.util.List;

public interface Database {
    String getStatus();
    List<Car> getAllCars();
    Car getCarById(Long id);

    String addCar(Car car);

    String deleteCarById(Long id) throws IOException;
}
