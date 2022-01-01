package ch.juventus.carrental.persistance;

import ch.juventus.carrental.app.Car;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.fileupload.FileUtils;
//import org.springframework.asm.TypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class FileDatabase implements Database {

    private String carRepository = "src/main/resources/carRepository.json";
    private ArrayList<Car> carList;
    private Long id;

    @Override
    public String loadHelloWorldGreeting() {
        return "Hello, world!";
    }

    @Override
    public ArrayList<Car> getAllCars() {
        /*
        ObjectMapper mapper = new ObjectMapper();
        try {
            carList = new ArrayList<>(Files.readAllLines(Paths.get(carRepository)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carList;

         */
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(new File(carRepository), new TypeReference<>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Car getCarById(Long id) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            ArrayList<Car> carList = mapper.readValue(new File(carRepository), new TypeReference<>() {});
            for (Car car : carList) {
               if (Objects.equals(car.getId(), id)) {
                   return car;
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
