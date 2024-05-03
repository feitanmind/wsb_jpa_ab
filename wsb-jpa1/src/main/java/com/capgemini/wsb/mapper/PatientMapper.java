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
            return new PatientTO(patientEntity.getId(),patientEntity.getFirstName(),patientEntity.getLastName(),patientEntity.getTelephoneNumber(),patientEntity.getEmail(), patientEntity.getPatientNumber(), patientEntity.getDateOfBirth(),AddressMapper.mapToTO(patientEntity.getAddress()), new ArrayList<>());
        }
        List<VisitTO> visits = new ArrayList<>();
        for(VisitEntity visitEntity : patientEntity.getVisits())
        {
            visits.add(VisitMapper.MapToVisitTO(visitEntity,true));
        }
        return new PatientTO(patientEntity.getId(),patientEntity.getFirstName(),patientEntity.getLastName(),patientEntity.getTelephoneNumber(),patientEntity.getEmail(), patientEntity.getPatientNumber(), patientEntity.getDateOfBirth(),AddressMapper.mapToTO(patientEntity.getAddress()), visits);
    }
}
