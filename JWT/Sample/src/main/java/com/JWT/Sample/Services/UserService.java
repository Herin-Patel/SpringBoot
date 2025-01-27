package com.JWT.Sample.Services;

import com.JWT.Sample.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> userList = new ArrayList<>();

    public UserService() {
        userList.add(new User(UUID.randomUUID().toString(), "Herin Patel", "herrypatel@gmail.com"));
        userList.add(new User(UUID.randomUUID().toString(), "Neep Jivani", "neepjivani@gmail.com"));
        userList.add(new User(UUID.randomUUID().toString(), "Niketa Patel", "niketapatel@gmail.com"));
        userList.add(new User(UUID.randomUUID().toString(), "Ashvin Patel", "ashvinpatel@gmail.com"));
        userList.add(new User(UUID.randomUUID().toString(), "Nisha Patel", "nishapatel@gmail.com"));
    }

   public List<User> getUserList(){
        return userList;
   }
}
