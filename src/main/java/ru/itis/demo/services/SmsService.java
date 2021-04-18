package ru.itis.demo.services;

public interface SmsService {
    void sendSms(String phone, String text);
}
