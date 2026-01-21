package com.linkedin.datasharingscopedvalue.challenge;

import static java.lang.ScopedValue.where;

public class OrderService {

    // OLD: Using ThreadLocal
    private static final ScopedValue<String> CURRENT_USER = ScopedValue.newInstance();

    void main() {
        // Simulate processing two orders
        processOrder("Ouidad", "ORD-001", 99.99);
        processOrder("Stephan", "ORD-002", 149.99);
    }

    static void processOrder(String username, String orderId, double amount) {
        // Set the user context
        where(CURRENT_USER, username).run(() -> processOrderInternal(orderId, amount));
    }

    private static void processOrderInternal(String orderId, double amount) {
        validateOrder(orderId, amount);
        saveOrder(orderId, amount);
        sendConfirmation(orderId);
    }

    static void validateOrder(String orderId, double amount) {
        log("Validating order " + orderId);
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
    }

    static void saveOrder(String orderId, double amount) {
        log("Saving order " + orderId + " for $" + amount);
    }

    static void sendConfirmation(String orderId) {
        log("Sending confirmation for order " + orderId);
    }

    static void log(String message) {
        // Read from ThreadLocal
        String user = CURRENT_USER.orElse("Unknown");
        System.out.println("[User: " + user + "] " + message);
    }
}
