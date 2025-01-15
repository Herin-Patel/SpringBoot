package com.Sample.Autowired;

import org.springframework.stereotype.Component;

@Component
public class Laptop {

    public void compile() {
        System.out.println("Laptop class object getting auto-wired into Dev class.");
    }
}
