package ch.juventus.carrental.app;

import ch.juventus.carrental.model.Car;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class CreateCars {
    public static void main(String[] args) {
        JSONObject carList = new JSONObject();
        Car car1 = new Car(1, "Mercedes E", "LIMOUSINE", "MANUAL", 4, 100, false);
        Car car2 = new Car(2, "BMW 5", "LIMOUSINE", "AUTOMATIC", 4, 120, true);
        Car car3 = new Car(3, "Toyota Prius", "COUPE", "AUTOMATIC", 2, 80, true);

        carList.put(1, car1.toString());
        carList.put(2, car2.toString());
        carList.put(3, car3.toString());
        try {
            FileWriter outFile = new FileWriter("c:/users/pas/carList.txt");
            outFile.write(carList.toJSONString());
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(carList);
    }

}
