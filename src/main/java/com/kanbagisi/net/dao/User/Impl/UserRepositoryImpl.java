package com.kanbagisi.net.dao.User.Impl;

import com.kanbagisi.net.entity.User;
import com.kanbagisi.net.dao.User.UserRepository;
import com.kanbagisi.net.util.JPAUtil;

import javax.persistence.EntityManager;

public class UserRepositoryImpl implements UserRepository{
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

}
