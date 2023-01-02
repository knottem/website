package com.example.website.entity.model;

import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;

@Entity
@Table(name = "account")
public class Account {

    private final static Logger logger = LogManager.getLogger(Account.class);
    @Id
    @Column(name = "account_number")
    private int accountNumber;

    @Column(name = "userid")
    private int userid;

    @Column(name = "balance")
    private double balance;

    @Column(name = "last_access")
    private Timestamp lastAcess;


    public Account() {}

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userId) {
        this.userid = userId;
    }

    public Timestamp getLastAcess() {
        return lastAcess;
    }

    public void setLastAcess(Timestamp lastacess) {
        this.lastAcess = lastacess;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userid=" + userid +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }

    public void printAccount() {
        String print = "Account" +
                " userid=" + userid +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance;
        logger.info(print);
        System.out.println(print);
    }
}