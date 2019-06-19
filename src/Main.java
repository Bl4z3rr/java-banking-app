
package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Your Bank!");
        System.out.println("Please select an option:");
        Main obj = new Main();
        obj.mainMenu();
    }

    public void printMenu() {
        System.out.println("1. Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Request overdraft");
        System.out.println("5. Exit");
        System.out.print("Enter Selection: ");
    }

    public void mainMenu() {
        printMenu();
        int selection = input.nextInt();
        switch (selection) {
            case 1:
                getAccountBalance();
            case 2:
                depositMoney();
            case 3:
                withdrawMoney();
            case 4:
                requestOverdraft();
            case 5:
                exit();
            default:
                System.out.print("No option selected. Goodbye.");
                exit();
        }
    }

    private void requestOverdraft() {
        System.out.print("Enter requested overdraft amount: ");

        double amount = input.nextDouble();

        this.currentAccount.setOverdraft(amount);
        System.out.println("Current overdraft: " + this.currentAccount.overdraft);
        mainMenu();
    }

    public void depositMoney() {
        System.out.print("Enter deposit amount: ");

        double amount = input.nextDouble();

        this.currentAccount.deposit(amount);
        System.out.println("Current Balance is: " + this.currentAccount.getBalance());
        mainMenu();
    }

    public void withdrawMoney() {
        System.out.print("Enter withdraw amount: ");

        double amount = input.nextDouble();

        this.currentAccount.withdraw(amount);
        System.out.println("Current Balance is: " + this.currentAccount.getBalance());
        mainMenu();
    }

    public void getAccountBalance() {
        System.out.println("Current balance is: " + this.currentAccount.getBalance());
        mainMenu();
    }

    public void exit() {
        System.exit(0);
    }

    Scanner input = new Scanner(System.in);
    Account currentAccount = new Account();

}

class Account {
    double balance = 0;
    double overdraft = 0;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance + overdraft) {
            System.out.println("Insufficient funds! You can request overdraft if needed.");

            return;
        }

        balance -= amount;
    }

    public void setOverdraft(double amount) {
        System.out.println("Processing...");
        try {
            Thread.sleep(1000);
            overdraft = overdraft + amount;

            System.out.println("Overdraft granted!");
        } catch (InterruptedException e) {
            System.out.println("Overdraft not granted!");
        }
    }

    public double getBalance() {
        return balance;
    }
}