package com.linkedin.flexibleconstructors;

public class SavingsAccount extends BankAccount {
    private final double interestRate;
    private final String accountType;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        // Validation and preparation before super()
        // Fail fast: validate before doing any work
        if (initialBalance < 100) {
            throw new IllegalArgumentException(
                    "Savings account requires minimum $100, got: $" + initialBalance);
        }

        if (interestRate < 0.01 || interestRate > 0.15) {
            throw new IllegalArgumentException(
                    "Interest rate must be between 1% and 15%, got: " +
                            (interestRate * 100) + "%");
        }

        // Initialize fields BEFORE super() to ensure integrity
        this.interestRate = interestRate;
        this.accountType = (initialBalance >= 10000) ? "PREMIUM" :
                (initialBalance >= 1000) ? "STANDARD" : "BASIC";
        // Now call superclass constructor
        super(accountNumber, initialBalance);

        // Additional setup after super()
        System.out.println("Account type: " + accountType +
                " with interest rate: " + (interestRate * 100) + "%");
    }

    @Override
    protected void logAccountCreation() {
        // This override is safe now because accountType is initialized!
        System.out.println("Savings account created: " + getAccountNumber() +
                " (Type: " + accountType + ")" +
                " with balance: $" + getBalance());
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getAccountType() {
        return accountType;
    }
}