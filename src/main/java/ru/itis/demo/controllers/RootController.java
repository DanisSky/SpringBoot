package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.demo.services.CarsService;

@Controller
public class RootController {
    @Autowired
    private CarsService carsService;

    @GetMapping("/")
    public String getCars(Model model) {
        model.addAttribute("carsList", carsService.getAllCars());
        return "root_page";
    }

}
