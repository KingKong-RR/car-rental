package ch.juventus.carrental.persistance;

import ch.juventus.carrental.app.Car;

import java.util.ArrayList;

public interface Database {
//    private Car car;
    String getStatus();
    ArrayList<Car> getAllCars();
    Car getCarById(Long id);

    String addCar(Car car);

    String deleteCarById(Long id);
}
