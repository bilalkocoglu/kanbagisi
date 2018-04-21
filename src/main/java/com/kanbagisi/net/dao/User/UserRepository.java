package com.kanbagisi.net.dao.User;

import com.kanbagisi.net.entity.User;

public interface UserRepository {

    public User login(String username, String password);

}
