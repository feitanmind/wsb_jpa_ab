package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.Dao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    public PatientEntity findByLastName(String lastName) {
        return entityManager.createQuery("SELECT u FROM PatientEntity u WHERE u.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getSingleResult();
    }
}
