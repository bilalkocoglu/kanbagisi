package com.kanbagisi.net.dao.State.impl;

import com.kanbagisi.net.dao.State.StateRepository;
import com.kanbagisi.net.entity.State;
import com.kanbagisi.net.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class StateRepositoryImpl implements StateRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

}
