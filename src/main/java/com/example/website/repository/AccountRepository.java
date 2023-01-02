package com.example.website.repository;

import com.example.website.entity.model.Account;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByuserid(int userid);
    Account findByAccountNumber(int accountNumber);

    @Modifying
    @Query("UPDATE Account a SET a.balance = :balance WHERE a.accountNumber = :accountNumber")
    void updateBalance(double balance, int accountNumber);

}
