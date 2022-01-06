package ch.juventus.carrental.controller;

import ch.juventus.carrental.app.Car;
import ch.juventus.carrental.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {
    private CarService carService;
    private CarController carController;

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    public void initRepo() {
    }

    @Test
    void getStatus() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/status")).andExpect(status().isOk());
    }

    @Test
    void getCarById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/car/1")).andExpect(status().isOk());
    }

    @Test
    void getAllCars() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cars")).andExpect(status().isOk());
    }

    @Test
    void deleteCarByID() {
    }
}