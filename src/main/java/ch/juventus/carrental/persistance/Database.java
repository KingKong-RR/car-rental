package ch.juventus.carrental.persistance;

import ch.juventus.carrental.app.Car;

import java.util.ArrayList;
import java.util.List;

public interface Database {
    String loadHelloWorldGreeting();
    ArrayList<Car> getAllCars();
    Car getCarById(Long id);
}
