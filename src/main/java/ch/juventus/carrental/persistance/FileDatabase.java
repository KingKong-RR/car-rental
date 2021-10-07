package ch.juventus.carrental.persistance;

import org.springframework.stereotype.Repository;

@Repository
public class FileDatabase implements Database {
    @Override
    public String loadHelloWorldGreeting() {
        return "Hello, world!";
    }


}
