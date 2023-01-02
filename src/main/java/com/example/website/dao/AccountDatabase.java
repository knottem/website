package com.example.website.dao;

import com.example.website.entity.model.Account;
import com.example.website.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountDatabase {

    private final AccountRepository accountRepository;

    public AccountDatabase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public int getAccountNumber() {
        int accountNumber;
        Random rand = new Random();
        while (true) {
            accountNumber = rand.nextInt(899999) + 100000;
            Account account = accountRepository.findByAccountNumber(accountNumber);
            if (account == null) {
                break;
            }
        }
        return accountNumber;
    }
}
