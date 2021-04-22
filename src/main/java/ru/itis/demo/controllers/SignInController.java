package ru.itis.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String getSignInPage(@RequestParam(value = "error", required = false) String errors, Model model) {
        model.addAttribute("errors", errors);
        return "sign_in_page";
    }

}
