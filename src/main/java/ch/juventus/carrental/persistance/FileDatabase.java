package ch.juventus.carrental.persistance;

import ch.juventus.carrental.app.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Repository;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FileDatabase implements Database {

    private String carRepository = "src/main/java/resources/carRepository.json";

    @Override
    public String loadHelloWorldGreeting() {
        return "Hello, world!";
    }

    @Override
    public List<Car> getAllCars() {
        String carListString = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList<String> carList = new ArrayList<>(Files.readAllLines(Paths.get(carRepository)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Car getCarById() {
        return null;
    }


}
