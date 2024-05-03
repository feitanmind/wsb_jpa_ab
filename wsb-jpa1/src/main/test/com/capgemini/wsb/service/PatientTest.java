package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientTest {
    @Autowired
    private PatientService patientService;
    @Autowired
    private VisitService visitService;

    @Transactional
    @Test
    public void testShouldReturnPatientTOWhenIdWasPassed()
    {
        //given
        final Long patientId = 1L;
        //when
        PatientTO patient = patientService.findById(patientId);
        //then
        assertEquals("Zuzanna", patient.getFirstName());
    }

    @Test
    public void testShouldRemoveVisitsWhenPatientWasDeleted()
    {
        //given
        final Long patientId = 1L;
        PatientTO patient = patientService.findById(patientId);
        List<VisitTO> patientsVists = patient.getVisits();
        Long firstVisitIdAssignedToPatient = patientsVists.get(0).getId();
        //when
        patientService.deleteById(patientId);
        //then
        VisitTO visitDto = visitService.getVisitById(firstVisitIdAssignedToPatient);
        assertNull(visitDto);
    }
}
