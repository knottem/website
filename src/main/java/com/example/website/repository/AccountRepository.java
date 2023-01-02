package com.example.website.repository;

import com.example.website.entity.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByuserid(int userid);
}
