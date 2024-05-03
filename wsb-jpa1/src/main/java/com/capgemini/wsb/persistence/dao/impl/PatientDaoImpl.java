package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.Dao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    public PatientEntity findByLastName(String lastName) {
        return entityManager.createQuery("SELECT u FROM PatientEntity u WHERE u.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getSingleResult();
    }

    @Override
    public List<PatientEntity> getPatientsWithMoreThanXVisits(int x) {
        return entityManager.createQuery("SELECT u FROM PatientEntity u JOIN u.visits v WHERE size(u.visits) > :x", PatientEntity.class)
                .setParameter("x",x)
                .getResultList();
    }

    @Override
    public List<PatientEntity> getPatientsWithPeselLessThanX(Long x) {
        return entityManager.createQuery("SELECT u FROM PatientEntity u WHERE u.pesel < :x",PatientEntity.class)
                .setParameter("x",x)
                .getResultList();
    }


}
