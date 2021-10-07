package ch.juventus.carrental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @GetMapping("/helloWorld")
    public ResponseEntity<String> helloWorld() {
        String response = "Hello world!";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
