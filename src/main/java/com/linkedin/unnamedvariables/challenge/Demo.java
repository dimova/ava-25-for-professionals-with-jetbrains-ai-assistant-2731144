package com.linkedin.unnamedvariables.challenge;


public class Demo {
    void main() {
        System.out.println("=== Task 1: Get Book Summary ===");
        com.linkedin.unnamedvariables.challenge.Book book1 = new com.linkedin.unnamedvariables.challenge.Book("Learn Java with Projects", "Seán and Maaike", 500, 49.99);
        System.out.println(com.linkedin.unnamedvariables.challenge.Library.getBookSummary(book1));

        System.out.println("\n=== Task 2: Load Book (with exception) ===");
        com.linkedin.unnamedvariables.challenge.Book loaded1 = Library.loadBook("books.txt");
        System.out.println("Loaded: " + loaded1.title());
    }
}
