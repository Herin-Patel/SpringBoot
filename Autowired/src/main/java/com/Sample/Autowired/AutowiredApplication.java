package com.Sample.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AutowiredApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AutowiredApplication.class, args);

        Dev obj = context.getBean(Dev.class);
        obj.build();
    }
}
