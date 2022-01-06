package ch.juventus.carrental.persistance;

import ch.juventus.carrental.CarRentalApplication;
import ch.juventus.carrental.app.Car;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class FileDatabase implements Database {
    private static final Logger logger = LogManager.getLogger(CarRentalApplication.class);
    private final String carRepository = "src/main/resources/carRepository.json";
    /* TODO Marked for removal
    private List<Car> carList;
    private Car car;
    private Long id;
    */

    private List<Car> readCarRepository() {
        List<Car> carList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            carList.addAll( mapper.readValue(new File(carRepository), new TypeReference<>() {
            }));
        } catch (MismatchedInputException e) {
            logger.info("No content in car repository");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }

        return carList;
    }

    @Override
    public String getStatus() {
        return "API OK";
    }

    @Override
    public List<Car> getAllCars() {
        return readCarRepository();
    }

    @Override
    public Car getCarById(Long id) {
       List<Car> carList = readCarRepository();
       for (Car car : carList) {
           if (Objects.equals(car.getId(), id)) {
               return car;
           }
       }
        return null;
    }

    @Override
    public String addCar(Car car) {
        List<Car> carList = readCarRepository();
        logger.info("Car added: " + car);
        carList.add(car);
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Paths.get(carRepository).toFile(),carList);
        } catch(MismatchedInputException e) {
            logger.info("No content in car repository");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    @Override
    public String deleteCarById(Long id) throws IOException {
        List<Car> carList = readCarRepository();
        carList = carList.stream().filter(carid -> id != id).collect(Collectors.toList());
        logger.info("Deleting car " + id);
        try {
            final ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(Paths.get(carRepository).toFile(),carList);
            return "Deleted";
        } catch(IOException ex) {
            ex.printStackTrace();
            logger.error(ex);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }

        return null;
    }

}
