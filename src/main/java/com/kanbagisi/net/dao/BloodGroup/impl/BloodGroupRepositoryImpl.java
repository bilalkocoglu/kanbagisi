package com.kanbagisi.net.dao.BloodGroup.impl;

import com.kanbagisi.net.dao.BloodGroup.BloodGroupRepository;
import com.kanbagisi.net.entity.BloodGroup;
import com.kanbagisi.net.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BloodGroupRepositoryImpl implements BloodGroupRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Transactional
    @Override
    public List getAllBloodGroup() {
        try {
            if (!em.getTransaction().isActive())
                em.getTransaction().begin();
            Map<String, Integer> allCity = new HashMap<String, Integer>();
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<BloodGroup> criteriaQuery = criteriaBuilder.createQuery(BloodGroup.class);
            Root<BloodGroup> cityRoot = criteriaQuery.from(BloodGroup.class);
            CriteriaQuery<BloodGroup> all = criteriaQuery.select(cityRoot);
            TypedQuery<BloodGroup> allQuery = em.createQuery(all);
            List list = allQuery.getResultList();
            return list;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
