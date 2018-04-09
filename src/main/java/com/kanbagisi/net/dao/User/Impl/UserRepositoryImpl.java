package com.kanbagisi.net.dao.User.Impl;

import com.kanbagisi.net.entity.User;
import com.kanbagisi.net.dao.User.UserRepository;
import com.kanbagisi.net.util.JPAUtil;

import javax.persistence.EntityManager;

public class UserRepositoryImpl implements UserRepository{
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public boolean save(User user) {
        try {
            if (!em.getTransaction().isActive())
                em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
