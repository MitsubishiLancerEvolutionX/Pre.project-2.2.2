package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @Autowired
    private Environment env;

    @GetMapping("/cars")
    public String showCars(@RequestParam(value = "count", defaultValue = "10") Integer count, Model model) {
        List<Car> list = carService.getCars(count);
        model.addAttribute("carsList", list);
        return "cars";
    }
}