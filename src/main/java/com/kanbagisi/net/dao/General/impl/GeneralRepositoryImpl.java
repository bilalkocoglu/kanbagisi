package com.kanbagisi.net.dao.General.impl;

import com.kanbagisi.net.dao.General.GeneralRepository;
import com.kanbagisi.net.util.JPAUtil;

import javax.persistence.EntityManager;

public class GeneralRepositoryImpl implements GeneralRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public boolean save(Object data) {
        try {
            if (!em.getTransaction().isActive())
                em.getTransaction().begin();
            em.persist(data);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
