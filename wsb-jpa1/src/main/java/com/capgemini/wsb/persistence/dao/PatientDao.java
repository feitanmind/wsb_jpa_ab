package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;

public interface PatientDao extends Dao<PatientEntity, Long>{
    /**
     * Zwraca pacjenta po jego nazwisku
     * @param lastName
     * @return PatientEntity
     */
    PatientEntity findByLastName(String lastName);
}
