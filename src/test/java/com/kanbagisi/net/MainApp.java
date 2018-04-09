package com.kanbagisi.net;

import com.kanbagisi.net.entity.User;
import com.kanbagisi.net.services.UserService;
import com.kanbagisi.net.util.JPAUtil;

import javax.persistence.EntityManager;

public class MainApp {
    public static void main(String [] args){
        UserService userService = new UserService();
        System.out.println(userService.save(new User("bilal", "kocoglu")));
    }
}
