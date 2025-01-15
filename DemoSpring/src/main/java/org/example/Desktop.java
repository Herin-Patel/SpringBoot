package org.example;

public class Desktop implements Computer {

    public Desktop() {
        System.out.println("This is a Desktop constructor");
    }

    public void compile() {
        System.out.println("Compiling in Desktop");
    }
}
