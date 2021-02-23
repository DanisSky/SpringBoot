package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.demo.services.MailConfirmService;

import java.util.Optional;

@Controller
public class ConfirmController {

    @Autowired
    private MailConfirmService mailConfirmService;

    @GetMapping("/confirm/{code}")
    public String confirmUser(@PathVariable("code") String code) {
        // TODO: реализовать сервис для подтерждения (найти по коду человека и поставить ему статус CONFIRMED)
        // TODO: вернуть страницу об успешном прохождении подтверждения
        Boolean isOk = mailConfirmService.isConfirmed(code);
        if (isOk) {
            return "confirmed_mail";
        }
        return null;
    }

}
