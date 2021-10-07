package ch.juventus.carrental.service;

import ch.juventus.carrental.persistance.Database;
import ch.juventus.carrental.persistance.FileDatabase;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private final Database database;

    public CarService(FileDatabase fileDatabase) {
        this.database = fileDatabase;
    }

    public String getHelloWorldGreeting() {
        return database.loadHelloWorldGreeting();
    }

}
