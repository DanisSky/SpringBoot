package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepository;

import java.util.Optional;

@Component
public class MailConfirmServiceImpl implements MailConfirmService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Boolean isConfirmed(String code) {
        Optional<User> user = usersRepository.findByConfirmCode(code);
        if (user.isPresent()) {
            user.get().setConfirmCode(code);
            usersRepository.save(user.get());
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
