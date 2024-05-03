package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.dao.DoctorDao;

import java.time.LocalDateTime;

public class VisitTO {
    private Long id;
    private String description;
    private LocalDateTime time;
    private DoctorTO doctor;
    private PatientTO patient;
    public VisitTO(){}
    public VisitTO(Long id, String description, LocalDateTime time, DoctorTO doctor, PatientTO patient)
    {
        this.id = id;
        this.description = description;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    public PatientTO getPatient() {
        return patient;
    }

    public void setPatient(PatientTO patient) {
        this.patient = patient;
    }
}
