package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;

public interface PatientService {

    public PatientTO findById(final Long id);

    public void delete(Long id);
    public List<VisitEntity> findAllVisitsByPatientId(Long patientId);
}
