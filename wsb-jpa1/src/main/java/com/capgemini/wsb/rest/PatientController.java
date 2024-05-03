package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/patient/{id}")
    PatientTO findById(@PathVariable("id") Long id) {
        final PatientTO patient = patientService.findById(id);
        if(patient != null) {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }
    @DeleteMapping("/patient/{id}")
    String deleteById(@PathVariable("id") Long id) {
        return  patientService.deleteById(id) ? "Deleted" : "Not Deleted";
    }
    @PostMapping("/patient/add")
    PatientTO addPatient(@RequestBody PatientTO patient) throws Exception {
        patientService.addPatient(patient);
        return patient;
    }
}
