package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {
    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    @Description("Lab3/Zad1 Znajdz pacjentow po nazwisku / DAO")
    public void testShouldReturnPatientWhenPassedLastName()
    {
        //given
        final String lastNameSearchingPatient = "Kamiński";
        final Long expectedPatientId = 2L;
        final String expectedPatientName = "Bartosz";
        //when
        PatientEntity patientEntity = patientDao.findByLastName(lastNameSearchingPatient);
        //then
        assertEquals(expectedPatientId, patientEntity.getId());
        assertEquals(expectedPatientName, patientEntity.getFirstName());
        assertEquals(patientDao.findOne(2L), patientEntity);
    }
}
