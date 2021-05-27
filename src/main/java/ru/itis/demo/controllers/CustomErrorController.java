package ru.itis.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class CustomErrorController {

    @GetMapping("/{error-number}")
    public String get404Page(@PathVariable("error-number") Long errorNumber, Model model) {
        model.addAttribute("error_number", errorNumber);
        return "error_page";
    }
}
