package ch.juventus.carrental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @GetMapping("/api/v1/helloWorld")
    public ResponseEntity<String> helloWorld() {
        String response = "Hello world!";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/api/v1/goodbyeWorld")
    public ResponseEntity<String> goodbyeWorld() {
        String response = "Goodbye, cruel world!";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
