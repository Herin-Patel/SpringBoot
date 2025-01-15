package com.WebExample.simpleWeb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
//    @ResponseBody
    public String greet() {
        return "Welcome to SpringBoot Website";
    }

    @RequestMapping("/about")
    public String about(){
        return "Directed the page to 'About' part of website";
    }
}
