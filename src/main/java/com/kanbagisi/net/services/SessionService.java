package com.kanbagisi.net.services;

import com.kanbagisi.net.dao.General.impl.GeneralRepositoryImpl;
import com.kanbagisi.net.dao.User.Impl.UserRepositoryImpl;
import com.kanbagisi.net.entity.User;

public class SessionService {
    GeneralRepositoryImpl generalRepository;
    UserRepositoryImpl userRepository;

    public SessionService() {
        generalRepository = new GeneralRepositoryImpl();
        userRepository = new UserRepositoryImpl();
    }

    public User userControl(String systemName, String systemPassword){
        User user = userRepository.login(systemName,systemPassword);
        if (user == null)
            return null;
        else
            return user;
    }
}
