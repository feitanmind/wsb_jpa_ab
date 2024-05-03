package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.enums.Sex;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jdk.jfr.Description;
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
    @Autowired
    private  DoctorService doctorService;

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
        assertEquals(Sex.FEMALE, patient.getSex());//Sprawdzenie dodanego customowego pola
        assertNotNull(patient.getPesel()); //Sprawdzenie customowego pola
    }

    @Test
    public void testShouldRemoveVisitsWhenPatientWasDeleted()
    {
        //given
        final Long patientId = 1L;
        PatientTO patient = patientService.findById(patientId);
        List<VisitTO> patientsVists = patient.getVisits();
        Long firstVisitIdAssignedToPatient = patientsVists.get(0).getId();
        Long secondVisitIdAssignedToPatient = patientsVists.get(1).getId();
        Long doctorAssigntToFirstVisit = 1L;
        Long doctorAssigntToSecondVisit = 4L;

        //when
        patientService.deleteById(patientId);
        //then
        VisitTO visitDto = visitService.getVisitById(firstVisitIdAssignedToPatient);
        VisitTO visitDto2 = visitService.getVisitById(secondVisitIdAssignedToPatient);
        assertNull(visitDto);
        assertNull(visitDto2);
        assertNotNull(doctorService.findById(doctorAssigntToFirstVisit));
        assertNotNull(doctorService.findById(doctorAssigntToSecondVisit));
    }
    @Test
    public void testShouldReturnAllStructureWhenFindPatient()
    {
        //given
        final Long patientId = 1L;
        //when
        PatientTO patient = patientService.findById(patientId);
        //then
        assertEquals(2,patient.getVisits().size());
        assertNotNull(patient.getAddress());
    }
    @Test
    @Description("Lab3/Zad2 Znajdz wszystkie wizyty pacjenta po jego ID / Service")
    public void testShouldGetAllVisitsForPatient()
    {
        //given
        final Long patientId = 1L;
        //when
        List<VisitTO> visits = patientService.findById(patientId).getVisits();
        //then
        assertEquals(2,visits.size());
        assertEquals("Przegląd ogólny",visits.get(0).getDescription());
        assertEquals("Kontrolna wizyta stomatologiczna",visits.get(1).getDescription());
    }
}
