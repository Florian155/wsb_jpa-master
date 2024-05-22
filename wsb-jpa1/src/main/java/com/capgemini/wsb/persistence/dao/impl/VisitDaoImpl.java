package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {

    @Override
    public List<VisitEntity> findAllByPatientId(Long patientId) {
        return entityManager.createQuery(
                        "SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId",
                        VisitEntity.class)
                .setParameter("patientId", patientId)
                .getResultList();
    }
}
