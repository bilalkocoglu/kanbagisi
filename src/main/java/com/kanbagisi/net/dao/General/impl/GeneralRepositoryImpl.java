package com.kanbagisi.net.dao.General.impl;

import com.kanbagisi.net.dao.General.GeneralRepository;
import com.kanbagisi.net.entity.City;
import com.kanbagisi.net.util.JPAUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GeneralRepositoryImpl implements GeneralRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Transactional
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

    @Transactional
    public <T> T findById(Class<T> clazz, int id){
        try {
            if (!em.getTransaction().isActive())
                em.getTransaction().begin();
            return em.find(clazz, id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
