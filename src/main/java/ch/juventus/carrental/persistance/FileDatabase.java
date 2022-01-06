package ch.juventus.carrental.persistance;

import ch.juventus.carrental.app.Car;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

@Repository
public class FileDatabase implements Database {

    private String carRepository = "src/main/resources/carRepository.json";
    private ArrayList<Car> carList;
    private Car car;
    private Long id;

    private ArrayList<Car> readCarRepository() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(new File(carRepository), new TypeReference<>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return carList;
    }

    @Override
    public String getStatus() {
        return "API OK";
    }

    @Override
    public ArrayList<Car> getAllCars() {
        ArrayList<Car> carList = readCarRepository();

        return carList;
    }

    @Override
    public Car getCarById(Long id) {
       ArrayList<Car> carList = readCarRepository();
       for (Car car : carList) {
           if (Objects.equals(car.getId(), id)) {
               return car;
           }
       }
        return null;
    }

    @Override
    public String addCar(Car car) {
        carList.add(car);
        return null;
    }

    @Override
    public String deleteCarById(Long id) throws IOException {
        ArrayList<Car> carList = readCarRepository();
        carList.removeIf(car -> Objects.equals(car.getId(), id));
        try {
            final ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(Paths.get(carRepository).toFile(),carList);
        } catch(IOException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
