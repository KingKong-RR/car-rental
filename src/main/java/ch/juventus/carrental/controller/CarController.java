package ch.juventus.carrental.controller;

import ch.juventus.carrental.CarRentalApplication;
import ch.juventus.carrental.app.Car;
import ch.juventus.carrental.model.Filter;
import ch.juventus.carrental.service.CarService;
import ch.juventus.carrental.util.FilterEditor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost,http://127.0.0.1", maxAge = 3600)
@RestController
public class CarController {

    private final CarService carService;
    private static final Logger logger = LogManager.getLogger(CarRentalApplication.class);

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @InitBinder
    @SuppressWarnings("unused")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Filter.class, new FilterEditor(new ObjectMapper()));
    }

    @CrossOrigin
    @GetMapping("/api/v1/status")
    public ResponseEntity<String> getStatus() {
        String response = carService.getStatus();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/v1/car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @GetMapping(path="/api/v1/cars", produces = "application/json")
    public ResponseEntity<List<Car>> getAllCars(@RequestParam(required = false) Filter filter) {
        List<Car> carList = carService.getAllCars(filter);

        logger.info("Hit API endpoint, showing " + carList);

        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/api/v1/car/{id}")
    public ResponseEntity<String> deleteCarByID(@PathVariable Long id) throws IOException {
        logger.info("Deleting car " + id + " from repository.");
        return new ResponseEntity<>(carService.deleteCarById(id), HttpStatus.OK);
    }

    @PostMapping(path="/api/v1/car")
    public ResponseEntity<String> addCar(@RequestBody Car car) {
        logger.info("Adding car to repository: " + car);
        carService.addCar(car);
        return null;
    }
/*
    @GetMapping("/api/v1/cars")
    public ResponseEntity<String> getCar(@RequestBody Car car) {
        logger.info("Searching for car with attributes: " + car);
        return null;
    }

 */
}
