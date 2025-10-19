package com.linkedin.flexibleconstructors;

public class Demo {
    void main(String[] args) {
        System.out.println("=== Example 1: Valid savings account ===");
        try {
            SavingsAccount account1 = new SavingsAccount("SA-001", 5000, 0.05);
            System.out.println("Success! Account type: " + account1.getAccountType());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Example 2: Fails fast - insufficient balance ===");
        try {
            SavingsAccount account2 = new SavingsAccount("SA-002", 50, 0.05);
        } catch (Exception e) {
            System.out.println("Error caught early: " + e.getMessage());
        }

        System.out.println("\n=== Example 3: Fails fast - invalid interest rate ===");
        try {
            SavingsAccount account3 = new SavingsAccount("SA-003", 1000, 0.25);
        } catch (Exception e) {
            System.out.println("Error caught early: " + e.getMessage());
        }

        System.out.println("\n=== Example 4: Premium account ===");
        try {
            SavingsAccount account4 = new SavingsAccount("SA-004", 15000, 0.08);
            System.out.println("Premium account created with " +
                    (account4.getInterestRate() * 100) + "% interest");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

