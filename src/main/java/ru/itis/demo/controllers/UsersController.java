package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.demo.services.UsersService;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public String getUsersPage(Model model) {
        model.addAttribute("usersList", usersService.getAllUsers());
        return "users_page";
    }
}
