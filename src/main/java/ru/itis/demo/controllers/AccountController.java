package ru.itis.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/account/profile")
    public String getProfilePage() {
        return "profile";
    }
}
