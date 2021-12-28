package ch.juventus.carrental.controller;

import ch.juventus.carrental.model.Car;
import ch.juventus.carrental.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping(path = "/api/v1/cars")
public class CarController {
    private static final Logger logger = LogManager.getLogger(CarController.class);

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
/*
    @GetMapping("/api/v1/helloWorld")
    public ResponseEntity<String> helloWorld() {
        String response = carService.getHelloWorldGreeting();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
*/

    @GetMapping("/api/v1/goodbyeWorld")
    public ResponseEntity<String> goodbyeWorld() {
        String response = "Goodbye, cruel world!";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/v1/helloKitty")
    public ResponseEntity<String> helloKitty() {
        String response = "Hello, Kitty!";

        logger.info("Hit API endpoint, showing meow");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
/*
    @GetMapping("cars/{id}")
    public ResponseEntity<String> sef(@PathVariable Long id, @RequestBody Car updatedCar) {
        return null;
    }

 */

    //public List<Car> getCars() {
    /*
    @GetMapping(path="/", produces = "application/json")
        public ResponseEntity<String> getCars() {
        //return (List<Car>) new ResponseEntity<List<Car>>(carService.getCars(), HttpStatus.OK);
        logger.info("Hit API endpoint, showing " + carService.getCars());
        //return carService.getCars();
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car(1, "Mercedes E", "LIMOUSINE", "MANUAL", 4, 100, false);
        Car car2 = new Car(2, "BMW 5", "LIMOUSINE", "AUTOMATIC", 4, 120, true);
        Car car3 = new Car(3, "Toyota Prius", "COUPE", "AUTOMATIC", 2, 80, true);
        carList.add(1, car1);
        carList.add(2, car2);
        carList.add(3, car3);
        return new ResponseEntity<String>("im here", HttpStatus.OK);
    }
     */

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
