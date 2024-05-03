package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.*;

import java.util.ArrayList;

public final class DoctorMapper {
    public static DoctorTO MapToDoctorTO(DoctorEntity doctorEntity, boolean isChild)
    {
        if(doctorEntity == null) return null;
        if(isChild)
        {
            return  new DoctorTO(doctorEntity.getId(),doctorEntity.getFirstName(),doctorEntity.getLastName(),doctorEntity.getTelephoneNumber(), doctorEntity.getEmail(), doctorEntity.getDoctorNumber(), doctorEntity.getSpecialization(),AddressMapper.mapToTO(doctorEntity.getAddress()) ,new ArrayList<>());
        }
        List<VisitTO> visits = new ArrayList<>();
        for(VisitEntity visit : doctorEntity.getVisitsEntities())
        {
            visits.add(VisitMapper.MapToVisitTO(visit,true));
        }
        return  new DoctorTO(doctorEntity.getId(),doctorEntity.getFirstName(),doctorEntity.getLastName(),doctorEntity.getTelephoneNumber(), doctorEntity.getEmail(), doctorEntity.getDoctorNumber(), doctorEntity.getSpecialization(),AddressMapper.mapToTO(doctorEntity.getAddress()) ,visits);

    }
}
