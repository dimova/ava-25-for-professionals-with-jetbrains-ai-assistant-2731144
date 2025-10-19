package com.linkedin.markdowndocs;

/**
 * <b>Dog</b> class represents a dog.
 * <p>
 * Usage example:
 * <pre>
 *   Dog d = new Dog("Fido");
 *   d.bark();
 * </pre>
 */
public class Dog {
    String name;
    Dog(String name) { this.name = name; }
    void bark() { System.out.println(name + " says woof!"); }
}

