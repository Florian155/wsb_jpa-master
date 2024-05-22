package com.capgemini.wsb.persistence.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testFindPatientsByLastName() {
        // Given
        String lastName = "Kowalska";

        // When
        List<PatientEntity> patients = patientDao.findByLastName(lastName);

        // Then
        assertNotNull(patients);
        assertEquals(1, patients.size());
    }

    @Test
    public void testFindPatientsWithMoreThanXVisits() {
        // Given
        Long x = 1L; // Assuming X is 1

        // When
        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanXVisits(x);

        // Then
        assertNotNull(patients);
        assertEquals(2, patients.size());
    }

    @Test
    public void testFindPatientsWithInsurance() {


        // When
        List<PatientEntity> patients = patientDao.findPatientsWithInsurance(true);

        // Then
        assertNotNull(patients);
        assertEquals(2, patients.size());
    }
}

