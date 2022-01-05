package ch.juventus.carrental.controller;

import ch.juventus.carrental.CarRentalApplication;
import ch.juventus.carrental.app.Car;
import ch.juventus.carrental.service.CarService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    private final CarService carService;
    private static final Logger logger = LogManager.getLogger(CarRentalApplication.class);

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/v1/helloWorld")
    public ResponseEntity<String> helloWorld() {
        String response = carService.getHelloWorldGreeting();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/v1/car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @GetMapping(path="/api/v1/cars", produces = "application/json")
    public ResponseEntity<List> getAllCars() {
        logger.info("Hit API endpoint, showing " + carService.getAllCars());

        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @PostMapping(path="/api/v1/car")
    /*
    public ResponseEntity<String> addCar(@RequestParam Long id, @RequestParam String name,
                                       @RequestParam String type, @RequestParam String gearShift,
                                       @RequestParam int seats, @RequestParam int pricePerDay,
                                       @RequestParam Boolean airCondition) {

     */
    /* TOFIX:
    public ResponseEntity<String> addCar(@RequestBody Long id, String name, String type, String gearShift,
                                               int seats, int pricePerDay, Boolean airCondition) {
        //Car car = new Car(new ObjectMapper().readValue(id, name, type, gearShift, seats, pricePerDay, airCondition), new TypeReference<>() {});
        carService.addCar(car);
        return new ResponseEntity<String>(car.toString(), HttpStatus.CREATED);
    }
     */
    // http://localhost:8080/api/v1/cars?filter={airCondition: false, type: SUV, etc}
    /*
    @GetMapping("/api/v1/cars")
    public ResponseEntity<String> getCar(@RequestParam(value = "filter", required = false) Filter filter) {
        if (filter != null) {
            //get all cars and apply filter
        } else {
            //get all cars
        }
    }
     */
}
