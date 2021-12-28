package ch.juventus.carrental.controller;

import ch.juventus.carrental.model.Car;
import ch.juventus.carrental.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/v1/helloWorld")
    public ResponseEntity<String> helloWorld() {
        String response = carService.getHelloWorldGreeting();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/v1/goodbyeWorld")
    public ResponseEntity<String> goodbyeWorld() {
        String response = "Goodbye, cruel world!";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/v1/helloKitty")
    public ResponseEntity<String> helloKitty() {
        String response = "Hello, Kitty!";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/v1/cars/{id}")
    public ResponseEntity<String> sef(@PathVariable Long id, @RequestBody Car updatedCar) {
        return null;
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {

    }
    // http://localhost:8080/api/va/cars?filter={airCondition: false, type: SUV, etc}
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
