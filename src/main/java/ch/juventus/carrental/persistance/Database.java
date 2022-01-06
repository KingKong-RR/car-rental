package ch.juventus.carrental.persistance;

import ch.juventus.carrental.app.Car;

import java.io.IOException;
import java.util.ArrayList;

public interface Database {
    String getStatus();
    ArrayList<Car> getAllCars();
    Car getCarById(Long id);

    String addCar(Car car);

    String deleteCarById(Long id) throws IOException;
}
