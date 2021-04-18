package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.AccountDto;
import ru.itis.demo.dto.AccountForm;
import ru.itis.demo.models.Account;
import ru.itis.demo.repositories.AccountsRepository;

import java.util.List;

import static ru.itis.demo.dto.AccountDto.from;

@Component
public class AccountsServiceImpl implements AccountsService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Override
    public List<AccountDto> getAllAccounts() {
        return from(accountsRepository.findAll());
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        return from(accountsRepository.findById(accountId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public AccountDto addAccount(AccountForm accountForm) {
        Account account = Account.builder()
                .email(accountForm.getEmail())
                .hashPassword(accountForm.getPassword())
                .build();
        accountsRepository.save(account);
        return AccountDto.from(account);
    }
}
