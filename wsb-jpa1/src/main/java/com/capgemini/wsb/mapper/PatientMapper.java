package com.capgemini.wsb.mapper;
import java.util.*;
import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.time.LocalTime;
import java.util.ArrayList;

public final class PatientMapper {
    public static PatientTO MapToPatientTO(PatientEntity patientEntity, boolean isChild)
    {
        if(patientEntity == null) return null;
        if(isChild)
        {
            return new PatientTO(patientEntity.getId(),patientEntity.getFirstName(),patientEntity.getLastName(),patientEntity.getTelephoneNumber(),patientEntity.getEmail(), patientEntity.getPatientNumber(), patientEntity.getDateOfBirth(),AddressMapper.mapToTO(patientEntity.getAddress()), new ArrayList<>(),patientEntity.getSex(),patientEntity.getPesel());
        }
        List<VisitTO> visits = new ArrayList<>();
        for(VisitEntity visitEntity : patientEntity.getVisits())
        {
            visits.add(VisitMapper.MapToVisitTO(visitEntity,true));
        }
        return new PatientTO(patientEntity.getId(),patientEntity.getFirstName(),patientEntity.getLastName(),patientEntity.getTelephoneNumber(),patientEntity.getEmail(), patientEntity.getPatientNumber(), patientEntity.getDateOfBirth(),AddressMapper.mapToTO(patientEntity.getAddress()), visits, patientEntity.getSex(), patientEntity.getPesel());
    }
    public static PatientEntity MapToPatientEntity(PatientTO patentTO)
    {
        if(patentTO == null) return null;
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patentTO.getId());
        patientEntity.setFirstName(patentTO.getFirstName());
        patientEntity.setLastName(patentTO.getLastName());
        patientEntity.setTelephoneNumber(patentTO.getTelephoneNumber());
        patientEntity.setDateOfBirth(patentTO.getDataOfBirth());
        patientEntity.setEmail(patentTO.getEmail());
        patientEntity.setPatientNumber(patentTO.getPatientNumber());
        patientEntity.setSex(patentTO.getSex());
        patientEntity.setPesel(patentTO.getPesel());
        return  patientEntity;
    }
}
