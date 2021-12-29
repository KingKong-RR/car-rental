package ch.juventus.carrental.controller;

import ch.juventus.carrental.app.Car;
import ch.juventus.carrental.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(path="/api/v1/cars", produces = "application/json")
    public ResponseEntity<List> getAllCars() {
        //return (List<Car>) new ResponseEntity<List<Car>>(carService.getCars(), HttpStatus.OK);
        //logger.info("Hit API endpoint, showing " + carService.getCars());
        //return carService.getCars();
        ArrayList<Car> carList = new ArrayList<>();
        Car car1 = new Car(1, "Mercedes E", "LIMOUSINE", "MANUAL", 4, 100, false);
        Car car2 = new Car(2, "BMW 5", "LIMOUSINE", "AUTOMATIC", 4, 120, true);
        Car car3 = new Car(3, "Toyota Prius", "COUPE", "AUTOMATIC", 2, 80, true);
        //carList.add(1, car1);
        //carList.add(2, car2);
        //carList.add(3, car3);
        //carList.add(1, car1);
        carList.add(new Car(1, "Fiat", "COUPE", "MANUAL", 4, 100, false));
        carList.add(new Car(2, "BMW 5", "LIMOUSINE", "AUTOMATIC", 4, 120, true));
        carList.add(new Car(3, "Toyota Prius", "COUPE", "AUTOMATIC", 2, 80, true));
        //String response = "im here";

        //return new ResponseEntity<>(carList.toString(), HttpStatus.OK);
        return new ResponseEntity<>(List.of(carList), HttpStatus.OK);
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
