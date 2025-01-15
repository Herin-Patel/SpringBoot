package com.Sample.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Dev {

//    private Laptop lobj = new Laptop();

    @Autowired     // Field-injection
    private Laptop lobj;

    public void build() {
        lobj.compile();
        System.out.println("Working on concept of auto-wired in SpringBoot");
    }
}
