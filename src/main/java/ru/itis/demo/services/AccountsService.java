package ru.itis.demo.services;

import ru.itis.demo.dto.AccountDto;
import ru.itis.demo.dto.AccountForm;
import ru.itis.demo.models.Account;

import java.util.List;

public interface AccountsService {
    List<AccountDto> getAllAccounts();

    AccountDto getAccountById(Long accountId);

    AccountDto addAccount(AccountForm accountForm);

    AccountDto getAccountByEmail(String email);
}
