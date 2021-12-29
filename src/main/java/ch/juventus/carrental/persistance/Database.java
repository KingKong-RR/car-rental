package ch.juventus.carrental.persistance;

import ch.juventus.carrental.app.Car;

import java.util.List;

public interface Database {
    String loadHelloWorldGreeting();
    List<Car> getAllCars();
    Car getCarById();
}
