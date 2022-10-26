package com.Shujauddin.Task_3.ATMInterface;

import java.util.ArrayList;
import java.util.List;

public class User {

    String name;
    Long accountNo;
    Integer pin;
    double balance;
    int attempts = 0;
    List<String> transactionHistory = new ArrayList<>();

    public User(Long accountNo) {
        this.accountNo = accountNo;
    }

    public User(String name,
                Long accountNo,
                Integer pin,
                double balance
    ) {
        this.name = name;
        this.accountNo = accountNo;
        this.pin = pin;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
}
