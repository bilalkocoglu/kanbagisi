package com.kanbagisi.net.services;

import com.kanbagisi.net.entity.User;
import com.kanbagisi.net.repositories.UserRepository;
import com.kanbagisi.net.util.JPAUtil;

import javax.persistence.EntityManager;

public class UserService implements UserRepository{
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public boolean save(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            JPAUtil.shutdown();
        }
    }
}
