package ch.juventus.carrental.persistance;

import ch.juventus.carrental.model.Car;
import org.springframework.stereotype.Repository;

@Repository
public class FileDatabase<car> implements Database {
    @Override
    public String loadHelloWorldGreeting() {
        return "Hello, world!";
    }

    @Override
    public Car getAllCars() {
        return null;
    }

    @Override
    public Car getCarById() {
        return null;
    }

    //  @Override
//    public void addCar(car){}

}
