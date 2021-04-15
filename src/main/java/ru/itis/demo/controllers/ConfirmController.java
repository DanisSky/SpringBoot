package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.demo.services.MailsService;

@Controller
public class ConfirmController {

    @Autowired
    private MailsService mailsService;

    @GetMapping("/confirm/{code}")
    public String confirmUser(@PathVariable("code") String code) {
        Boolean isConfirmed = mailsService.isConfirmed(code);
        if (isConfirmed) {
            return "confirmed_mail";
        }
        return null;
    }
}
