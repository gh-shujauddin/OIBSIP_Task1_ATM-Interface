package com.Shujauddin.Task_3.ATMInterface;

import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user = new User("Shujauddin",1234567L, 3456, 20_000);

        boolean exit = false;

        ATMFunctions ATMfunctions = new ATMFunctions(user);

        System.out.println("Welcome to Qadri's Bank!");
        while (true) {
            System.out.println("");
            System.out.print("Please Enter User ID: ");
            Long userID = sc.nextLong();
            System.out.print("Please Enter PIN: ");
            int password = sc.nextInt();

            boolean login = ATMfunctions.login(userID, password);
            if (login) {
                ATMfunctions.accessed = true;

                while (!exit) {
                    System.out.println("\nPlease enter your Choice: ");
                    System.out.println("Press:\n" +
                            "\t1- Transaction History\n" +
                            "\t2- Withdraw\n" +
                            "\t3- Deposit\n" +
                            "\t4- Transfer\n" +
                            "\t5- Quit\n"
                    );
                    System.out.print("Enter your choice: ");
                    int choice = sc.nextInt();

                    switch (choice) {

                        case 1 -> {
                            System.out.format("\nTransaction History of %s\n", user.getName());
                            for (String q : user.transactionHistory) {
                                System.out.println(q);
                            }
                        }

                        case 2 -> {
                            System.out.print("Enter the amount to withdraw: ");
                            double withdraw = sc.nextInt();
                            ATMfunctions.withdraw(withdraw);
                        }

                        case 3 -> {
                            System.out.println("Enter the amount to deposit: ");
                            double deposit = sc.nextInt();
                            ATMfunctions.deposit(deposit);
                        }

                        case 4 -> {
                            System.out.print("Enter the account to transfer: ");
                            Long transAcc = sc.nextLong();
                            System.out.print("Enter amount: ");
                            double transferAmount = sc.nextDouble();
                            ATMfunctions.transfer(transAcc, transferAmount);
                        }

                        case 5 -> {
                            System.out.println("Logged Out Successfully.. Please Visit Again.");
                            exit = true;
                        }
                        default -> System.out.println("You entered wrong choice.");
                    }
                }
                break;
            } else {
                user.setAttempts(user.getAttempts() + 1);
                if (user.getAttempts() >= 3) {
                    System.out.println("Number of attempts exceeded. Please contact bank for changing username or password.");
                    break;
                }
            }
        }
    }
}
