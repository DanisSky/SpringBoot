package ru.itis.demo.services;

public interface MailsService {
    void sendEmailForConfirm(String email, String code);
    Boolean isConfirmed(String code);

}
