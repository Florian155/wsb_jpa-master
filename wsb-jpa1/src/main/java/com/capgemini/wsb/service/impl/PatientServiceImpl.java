package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao;
    private final VisitDao visitDao;

    @Autowired
    public PatientServiceImpl(PatientDao ppatientDao, VisitDao vvisitDao) {
        patientDao = ppatientDao;
        visitDao = vvisitDao;
    }

    @Override
    public PatientTO findById(Long id) {
        PatientEntity entity = patientDao.findOne(id);

        return PatientMapper.mapToTO(entity);
    }

    @Override
    public void delete(Long patientId) {
        PatientEntity patient = patientDao.findOne(patientId);

        patientDao.delete(patient);
    }
    @Override

    public List<VisitEntity> findAllVisitsByPatientId(Long patientId) {
        return visitDao.findAllByPatientId(patientId);
    }
}
