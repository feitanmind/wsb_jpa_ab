package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.dao.impl.AddressDaoImpl;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public final class VisitMapper {
    public static VisitTO MapToVisitTO(final VisitEntity visitEntity, boolean isChild)
    {
        if(visitEntity == null) return null;
        if(isChild)
        {
            //Puste obiekty doctor oraz patient bo java nie ma typów nullowalnych a dla childa jest to nieważne bo wywołane jest z pacjenta bądź doktora
            return new VisitTO(visitEntity.getId(),visitEntity.getDescription(), visitEntity.getTime(),new DoctorTO(),new PatientTO());
        }
        return new VisitTO(visitEntity.getId(),visitEntity.getDescription(), visitEntity.getTime(), DoctorMapper.MapToDoctorTO(visitEntity.getDoctor(),true),PatientMapper.MapToPatientTO(visitEntity.getPatient(),true));
    }
    public static VisitEntity MapToVisitEntity(final VisitTO visitTO)
    {
        if(visitTO  == null) return null;
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
        visitEntity.setDoctor(DoctorMapper.MapToDoctorEntity(visitTO.getDoctor()));
        visitEntity.setPatient(PatientMapper.MapToPatientEntity(visitTO.getPatient()));
        return visitEntity;

    }

}
