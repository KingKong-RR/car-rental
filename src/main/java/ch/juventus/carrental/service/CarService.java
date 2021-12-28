package ch.juventus.carrental.service;

import ch.juventus.carrental.model.Car;
import ch.juventus.carrental.persistance.Database;
import ch.juventus.carrental.persistance.FileDatabase;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CarService {
    private final FileDatabase database;

    public CarService(FileDatabase fileDatabase) {
        this.database = fileDatabase;
    }
/*
    public String getHelloWorldGreeting() {
        return database.loadHelloWorldGreeting();
    }

 */

    public List<Car> getCars() {
//        return FileDatabase.getAllCars();
//        log.info("Fetching all cars");
        FileDatabase carList = new FileDatabase<>();
        return carList.getAllCars();
    }

//    public List<Car> getAllCars() { return database.getAllCars(); }

   // public Car getCarById(String id) { return database.getCarById(); }

   // public void addCar(Car car) { return database.addCar(car); }


}
