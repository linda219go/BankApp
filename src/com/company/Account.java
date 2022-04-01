package com.company;

import java.util.Scanner;

public class Account {
    //class variable
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;
    //class constructor
    Account(String cname, String cid){
        customerName = cname;
        customerID = cid;
    }
    //function for depositing money
    void deposit(int amount){
        if(amount != 0){
            balance += amount;
            previousTransaction = amount;
        }
    }
    void withdraw(int amount){
        if(amount != 0){
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    //show previous transaction
    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if(previousTransaction < 0){
            System.out.println("Withdrawn: " + previousTransaction);
        }else{
            System.out.println("No transaction");
        }
    }
    //function calculate interest of current funds after a number of years
    void calcInterest(int years){
        double interestRate = 0.0185;
        double newBalance = balance * (1+interestRate*years);
        System.out.println("The current interest rate is " + interestRate*100 + "%");
        System.out.println("After "+ years +" years, your balance will be: "+newBalance);
    }

    //function show the main menu
    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, "+customerName);
        System.out.println("Your ID is: "+ customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println("-------------------------");
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            switch (option){
                case 'A':
                    System.out.println("Your current balance = $" + balance);

                    break;
                case 'B':
                    System.out.println("Enter an amount you want to deposit: ");
                    int amountD = scanner.nextInt();
                    deposit(amountD);
                    System.out.println("Deposit Done");
                    break;
                case 'C':
                    System.out.println("Enter an amount you want to withdraw: ");
                    int amountW = scanner.nextInt();
                    withdraw(amountW);
                    System.out.println("Withdraw Done");
                    break;
                case 'D':
                    getPreviousTransaction();

                    break;
                case 'E':
                    System.out.println("Enter the year you want to keep: ");
                    int year = scanner.nextInt();
                    calcInterest(year);

                    break;
                case 'F':
                    System.out.println();
                    break;
                default:
                    System.out.println("Please input correct option");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thanks for banking with us");
    }
}
