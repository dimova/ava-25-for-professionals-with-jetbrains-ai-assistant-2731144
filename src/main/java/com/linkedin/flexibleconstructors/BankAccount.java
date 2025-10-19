package com.linkedin.flexibleconstructors;

public class BankAccount {
    private final String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        logAccountCreation();
    }

    protected void logAccountCreation() {
        System.out.println("Account created: " + accountNumber +
                " with balance: $" + balance);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
