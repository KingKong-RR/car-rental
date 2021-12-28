package ch.juventus.carrental.persistance;

import ch.juventus.carrental.model.Car;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileDatabase<car> {
    //FileReader infile = "c:/users/pas/carList.txt";
    //JSONParser parser = new JSONParser();
    //List jsonFileDB = parser.parse(new FileReader("c:/users/pas/carList.txt"));
/*
    @Override
    public String loadHelloWorldGreeting() {
        return "Hello, world!";
    }

 */

    //@Override
    public List<Car> getAllCars() {
        //JSONObject carList = new JSONObject();
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car(1, "Mercedes E", "LIMOUSINE", "MANUAL", 4, 100, false);
        Car car2 = new Car(2, "BMW 5", "LIMOUSINE", "AUTOMATIC", 4, 120, true);
        Car car3 = new Car(3, "Toyota Prius", "COUPE", "AUTOMATIC", 2, 80, true);
        carList.add(1, car1);
        carList.add(2, car2);
        carList.add(3, car3);
        return (List<Car>) carList;
    }

//    @Override
    public Car getCarById() {
        return null;
    }



    //  @Override
//    public void addCar(car){}

}
