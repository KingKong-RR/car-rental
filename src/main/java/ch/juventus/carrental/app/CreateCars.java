package ch.juventus.carrental.app;

import ch.juventus.carrental.model.Car;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class CreateCars {
    public static void main(String[] args) {
        JSONObject carList = new JSONObject();
        Car car1 = new Car(1, "Mercedes E", "LIMOUSINE", "MANUAL", 4, 100, false);
        carList.put(1, car1.toString());
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
