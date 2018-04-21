package com.kanbagisi.net.dao.City.impl;

import com.kanbagisi.net.dao.City.CityRepository;
import com.kanbagisi.net.entity.City;
import com.kanbagisi.net.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CityRepositoryImpl implements CityRepository{
        private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();


    @Transactional
    @Override
    public List getAllCity(){
        try {
            if (!em.getTransaction().isActive())
                em.getTransaction().begin();
            Map<String, Integer> allCity = new HashMap<String, Integer>();
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<City> criteriaQuery = criteriaBuilder.createQuery(City.class);
            Root<City> cityRoot = criteriaQuery.from(City.class);
            CriteriaQuery<City> all = criteriaQuery.select(cityRoot);
            all.orderBy(criteriaBuilder.asc(cityRoot.get("cityName")));
            TypedQuery<City> allQuery = em.createQuery(all);
            List list = allQuery.getResultList();
            return list;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
