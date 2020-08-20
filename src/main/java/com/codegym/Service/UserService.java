package com.codegym.Service;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static List<User> userList;

    static {
        userList = new ArrayList<>();
        User user1 = new User();
        user1.setAge(10);
        user1.setName("John");
        user1.setAccount("john");
        user1.setEmail("john@codegym.vn");
        user1.setPassword("123456");
        userList.add(user1);
        User user2 = new User();
        user2.setAge(15);
        user2.setName("Bill");
        user2.setAccount("bill");
        user2.setEmail("bill@codegym.vn");
        user2.setPassword("123456");
        userList.add(user2);

        User user3 = new User();
        user3.setAge(16);
        user3.setName("Mike");
        user3.setAccount("mike");
        user3.setEmail("mike@codegym.vn");
        user3.setPassword("123456");
        userList.add(user3);
    }

    public static User checkLogin(Login login) {
        for (User user : userList) {
            if (user.getAccount().equals(login.getAccount()) && user.getPassword().equals(login.getPassword()))
                return user;
        }
        return null;
    }
}
