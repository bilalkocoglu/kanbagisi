package com.kanbagisi.net.dao.State.impl;

import com.kanbagisi.net.dao.State.StateRepository;
import com.kanbagisi.net.entity.State;
import com.kanbagisi.net.util.JPAUtil;

import javax.persistence.EntityManager;

public class StateRepositoryImpl implements StateRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public State findStateById(int id) {
        try{
            if (!em.getTransaction().isActive())
                em.getTransaction().begin();
            State state = em.find(State.class,id);
            return state;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
