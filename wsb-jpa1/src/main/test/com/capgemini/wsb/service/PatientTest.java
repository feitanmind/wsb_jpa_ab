package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientTest {
    @Autowired
    private PatientService patientService;

    @Transactional
    @Test
    public void testShouldReturnPatientWhenIdWasPassed()
    {
        //given
        final Long patientId = 1L;
        //when
        PatientTO patient = patientService.findById(patientId);
        //then
        assertEquals("Zuzanna", patient.getFirstName());
    }
}
