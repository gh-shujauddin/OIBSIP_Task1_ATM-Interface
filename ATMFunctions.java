package com.Shujauddin.Task_3.ATMInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ATMFunctions {

    User user1;
    User user2 = new User(98765L);
    Boolean accessed = false;

    LocalDate localDate = LocalDate.now();
    String date = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    LocalTime localTime = LocalTime.now();
    String time = localTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"));

    public ATMFunctions(User user) {
        this.user1 = user;
    }

    public boolean login(Long accountNumber, Integer pin) {
        if (user1.getAccountNo().equals(accountNumber) && user1.getPin().equals(pin)) {
            System.out.println("Logged In Successfully :)");
            System.out.format("\nWelcome %s, Your account Balance is: ₹%.2f",user1.getName(), user1.getBalance());
            return true;
        } else {
            System.out.println("Invalid Account Number or PIN! Attempt: " + (user1.getAttempts() + 1));
            return false;
        }
    }

//    public void displayBalance() {
//        if (accessed) {
//            System.out.println("Account Balance: " + user1.getBalance());
//        }
//    }

    public void withdraw(double amount) {
        if (accessed) {
            if (user1.getBalance() < amount) {
                System.out.println("Insufficient Balance. Please retry.");
            } else {
                user1.setBalance(user1.getBalance() - amount);
                System.out.println("Withdrawn Successfully.");
                String withdrawnStat = "Withdrawn Amount: " + amount + "\t\t Date: " + date + " at " + time;
                user1.transactionHistory.add(withdrawnStat);
                System.out.println("Account Balance: " + user1.getBalance());
            }
        }
    }

    public void deposit(double amount) {
        user1.setBalance(user1.getBalance() + amount);
        System.out.println("Deposited Successfully.");
        String depositStat = "Deposit Amount: " + amount + "\t\t Date: " + date + " at " + time;
        user1.transactionHistory.add(depositStat);
        System.out.println("Account Balance: " + user1.getBalance());
    }

    public void transfer(Long accountNo, double amount) {
        if (accessed){
            if (user2.getAccountNo().equals(accountNo)) {
                if (user1.getBalance() < amount) {
                    System.out.println("Insufficient Balance. Try again.");
                } else {
                    user1.setBalance(user1.getBalance() - amount);
                    System.out.println(amount + " successfully transferred to " + accountNo);
                    String transferStat = amount + " transfer to " + accountNo + "\t\t Date: " + date + " at " + time;
                    user1.transactionHistory.add(transferStat);
                    System.out.println("Account Balance: " + user1.getBalance());
                }
            } else {
                System.out.println("Invalid Account Number. Please try again.");
            }
        }
    }
}
