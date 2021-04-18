package ru.itis.demo.services;

import ru.itis.demo.dto.AccountDto;
import ru.itis.demo.dto.AccountForm;

import java.util.List;

public interface AccountsService {
    List<AccountDto> getAllAccounts();

    AccountDto getAccountById(Long accountId);

    AccountDto addAccount(AccountForm accountForm);

}
