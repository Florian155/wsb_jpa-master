package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.ArrayList;
import java.util.List;

public final class PatientMapper {

    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setHasInsurance(patientEntity.isHasInsurance());

        return patientTO;
    }
    private static List<VisitTO> mapVisits(List<VisitEntity> visitEntities) {
        if (visitEntities == null) {
            return null;
        }
        List<VisitTO> visitTOs = new ArrayList<>();
        for (VisitEntity visitEntity : visitEntities) {
            VisitTO visitTO = new VisitTO();
            visitTO.setId(visitEntity.getId());
            visitTO.setVisitDateTime(visitEntity.getTime());
            visitTO.setDoctorName(visitEntity.getDoctor().getLastName());
            visitTOs.add(visitTO);
        }
        return visitTOs;
    }
    public static PatientEntity mapToEntity(PatientTO patientTO) {
        if (patientTO == null) {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setHasInsurance(patientTO.isHasInsurance());
        return patientEntity;
    }

}