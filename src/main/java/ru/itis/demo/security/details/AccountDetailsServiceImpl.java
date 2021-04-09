package ru.itis.demo.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.demo.models.Account;
import ru.itis.demo.repositories.AccountsRepository;

import java.util.Optional;

@Component("customUserDetailsService")
public class AccountDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> accountCandidate = accountsRepository.findByEmail(email);
        if (accountCandidate.isPresent()) {
            return new AccountDetailsImpl(accountCandidate.get());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }


}
