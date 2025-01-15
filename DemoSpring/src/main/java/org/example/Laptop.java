package org.example;

public class Laptop implements  Computer{

    public Laptop() {
        System.out.println("This is a Laptop constructor");
    }

    public void compile() {
        System.out.println("Compiling in Laptop");
    }
}
