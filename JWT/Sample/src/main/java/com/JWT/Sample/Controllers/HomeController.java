package com.JWT.Sample.Controllers;

import com.JWT.Sample.Model.User;
import com.JWT.Sample.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    // http://localhost:8081/home/user
    @GetMapping("/users")
    public List<User> getuser() {
        System.out.println("Getting users.....");
        return this.userService.getUserList();
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
