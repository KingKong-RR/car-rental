package ch.juventus.carrental.service;

import ch.juventus.carrental.persistance.FileDatabase;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private final FileDatabase fileDatabase;

    public CarService(FileDatabase fileDatabase) {
        this.fileDatabase = fileDatabase;
    }

    public String getHelloWorldGreeting() {
        return fileDatabase.loadHelloWorldGreeting();
    }

}
