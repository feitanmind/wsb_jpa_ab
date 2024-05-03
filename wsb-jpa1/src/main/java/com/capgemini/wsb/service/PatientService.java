package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;

public interface PatientService {
    PatientTO findById(Long id);
    Long deleteById(Long id);
    PatientTO addPatient(PatientTO patientTO);
    PatientTO updatePatient(PatientTO patientTO);
}
