package com.linkedin.markdowndocs;

/// # MarkdownDog
/// The `MarkdownDog` class represents a dog.
///
/// ## Usage example
/// ```java
/// MarkdownDog d = new MarkdownDog("Max");
/// d.bark();
/// ```
class MarkdownDog {
    String name;
    MarkdownDog(String name) { this.name = name; }
    void bark() { System.out.println(name + " says woof!"); }
}