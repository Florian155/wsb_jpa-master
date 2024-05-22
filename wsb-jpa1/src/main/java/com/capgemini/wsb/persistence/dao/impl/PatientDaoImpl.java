package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery("select pat from PatientEntity pat WHERE pat.lastName = :lastName ", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }
    @Override
    public List<PatientEntity> findPatientsWithMoreThanXVisits(Long x) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE (SELECT COUNT(v) FROM VisitEntity v WHERE v.patient.id = p.id) > :visitCount",
                        PatientEntity.class)
                .setParameter("visitCount", x)
                .getResultList();
    }
    @Override
    public List<PatientEntity> findPatientsWithInsurance(boolean insurance) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.hasInsurance = :insurance",
                        PatientEntity.class)
                .setParameter("insurance", insurance)
                .getResultList();
    }

    }
