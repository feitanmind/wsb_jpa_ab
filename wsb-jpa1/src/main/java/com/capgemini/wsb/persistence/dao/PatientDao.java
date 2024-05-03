package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import java.util.*;

public interface PatientDao extends Dao<PatientEntity, Long>{
    /**
     * Zwraca pacjenta po jego nazwisku
     * @param lastName
     * @return PatientEntity
     */
    PatientEntity findByLastName(String lastName);

    /**
     * Zwraca pacjentow ktorzy mieli wiecej niz X wizyt (X jest parametrem wejsciowym)
     * @param x
     * @return
     */
    List<PatientEntity> getPatientsWithMoreThanXVisits(int x);
}
