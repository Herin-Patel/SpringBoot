package com.WebApplication.simpleEcom;

import com.WebApplication.simpleEcom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements CommandLineRunner {

    @Autowired
    private ProductRepo repo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading existing data from MySQL.....");
        repo.findAll().forEach(product -> System.out.println(product.getName()));
    }
}
