package com.kanbagisi.net.dao.User.Impl;

import com.kanbagisi.net.entity.User;
import com.kanbagisi.net.dao.User.UserRepository;
import com.kanbagisi.net.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.MapAttribute;
import java.util.Iterator;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public User login(String username, String password) {
        try {
            if (!em.getTransaction().isActive())
                em.getTransaction().begin();
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> userRoot = criteriaQuery.from(User.class);
            Predicate predicate = criteriaBuilder.conjunction();
            predicate = criteriaBuilder.and(criteriaBuilder.equal(userRoot.get("userSystemName"),username),
                    criteriaBuilder.equal(userRoot.get("userSystemPass"),password));
            criteriaQuery.select(userRoot);
            criteriaQuery.where(predicate);
            List<User> userList = this.em.createQuery(criteriaQuery).getResultList();
            if (userList.isEmpty())
                return null;
            Iterator<User> userIterator = userList.iterator();
            while (userIterator.hasNext()){
                User user = userIterator.next();
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
