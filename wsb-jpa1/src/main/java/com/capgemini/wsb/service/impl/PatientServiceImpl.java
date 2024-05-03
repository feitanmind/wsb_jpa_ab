package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao;
    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity patientEntity = patientDao.findOne(id);
        PatientTO patientTO = PatientMapper.MapToPatientTO(patientEntity,false);
        return patientTO;
    }

    @Override
    public boolean deleteById(Long id) {
        try{
            PatientEntity patient = patientDao.findOne(id);
            patientDao.delete(patient);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }

    @Override
    public PatientTO addPatient(PatientTO patientTO) throws Exception {
        if(patientTO == null) throw new Exception("Patient cannot be null");
        patientDao.save(PatientMapper.MapToPatientEntity(patientTO));
        return patientTO;
    }

    @Override
    public PatientTO updatePatient(PatientTO patientTO) {
        PatientEntity patientEntity = patientDao.findOne(patientTO.getId());
        PatientEntity patientUpdated = PatientMapper.MapToPatientEntity(patientTO);
        patientDao.update(patientUpdated);
        return patientTO;
    }
}
