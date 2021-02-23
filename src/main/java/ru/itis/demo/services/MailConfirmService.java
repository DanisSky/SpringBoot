package ru.itis.demo.services;

public interface MailConfirmService {
    Boolean isConfirmed(String code);
}
