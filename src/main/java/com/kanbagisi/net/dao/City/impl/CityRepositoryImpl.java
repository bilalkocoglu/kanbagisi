package com.kanbagisi.net.dao.City.impl;

import com.kanbagisi.net.dao.City.CityRepository;
import com.kanbagisi.net.entity.City;
import com.kanbagisi.net.util.JPAUtil;

import javax.persistence.EntityManager;

public class CityRepositoryImpl implements CityRepository{
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public City findCity(int id) {
        try {
            if (!em.getTransaction().isActive())
                em.getTransaction().begin();
            City city1 = em.find(City.class,id);
            return city1;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
