package ch.juventus.carrental.persistance;

import ch.juventus.carrental.model.Car;

public interface Database {
    String loadHelloWorldGreeting();
    Car getAllCars();

    Car getCarById();

//    void addCar(Car car);
}
