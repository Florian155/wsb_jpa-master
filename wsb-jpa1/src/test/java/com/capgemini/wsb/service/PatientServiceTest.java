package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        // when
        PatientEntity patientEntity = patientDao.findOne(1L);
        // then
        assertThat(patientEntity).isNotNull();
        assertThat(patientEntity.getFirstName()).isEqualTo("Adam");
    }

    @Test
    public void testShouldSaveAddress() {
        // given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setLastName("Walker");
        patientEntity.setFirstName("Mark");
        patientEntity.setPatientNumber("222-333");
        patientEntity.setHasInsurance(true);
        patientEntity.setDateOfBirth(LocalDate.of(2023, 4, 21));
        patientEntity.setEmail("email");
        patientEntity.setTelephoneNumber("231-566");

        long entitiesNumBefore = patientDao.count();

        // when
        final PatientEntity saved = patientDao.save(patientEntity);

        // then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(patientDao.count()).isEqualTo(entitiesNumBefore + 1);
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemovePatient() {
        // given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setLastName("Walker");
        patientEntity.setFirstName("Mark");
        patientEntity.setPatientNumber("222-333");
        patientEntity.setHasInsurance(true);
        patientEntity.setDateOfBirth(LocalDate.of(2023, 4, 21));
        patientEntity.setEmail("email");
        patientEntity.setTelephoneNumber("231-566");

        // when
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setTime(LocalDateTime.of(2023, 5, 1, 15, 42));
        visitEntity.setPatient(patientEntity);
        patientEntity.setVisits(Collections.singletonList(visitEntity));

        // when
        final PatientEntity savedPatient = patientDao.save(patientEntity);
        visitDao.save(visitEntity);

        assertThat(savedPatient.getId()).isNotNull();
        assertThat(savedPatient.getVisits()).hasSize(1);

        final PatientEntity newSavedPatient = patientDao.findOne(savedPatient.getId());
        assertThat(newSavedPatient).isNotNull();
        assertThat(newSavedPatient.getVisits()).hasSize(1);

        patientDao.delete(savedPatient.getId());

        // then
        final PatientEntity removedPatient = patientDao.findOne(savedPatient.getId());
        assertThat(removedPatient).isNull();

        final VisitEntity removedVisit = visitDao.findOne(visitEntity.getId());
        assertThat(removedVisit).isNull();
    }
    @Test
    public void testFindPatientByIdShouldReturnPatientTO() {
        // Given
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setTelephoneNumber("111");
        doctorEntity.setSpecialization(Specialization.SURGEON);
        doctorEntity.setLastName("Smith");
        doctorEntity.setFirstName("Will");
        doctorEntity.setId(1L);
        doctorEntity.setDoctorNumber("621");

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setLastName("Walker");
        patientEntity.setFirstName("Mark");
        patientEntity.setPatientNumber("222-333");
        patientEntity.setHasInsurance(true);
        patientEntity.setDateOfBirth(LocalDate.of(2023, 4, 21));
        patientEntity.setEmail("email");
        patientEntity.setTelephoneNumber("231-566");

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setTime(LocalDateTime.of(2024,4,2,14,15));
        visitEntity.setDoctor(doctorEntity);
        visitEntity.setPatient(patientEntity);

        List<VisitEntity> visits = new ArrayList<>();
        visits.add(visitEntity);

        patientEntity.setVisits(visits);

        // Zapisz pacjenta
        patientDao.save(patientEntity);

        // When
        PatientTO patientTO = patientService.findById(patientEntity.getId());

        // Then
        assertNotNull(patientTO);
        assertEquals(patientEntity.getId(), patientTO.getId());
        assertEquals(patientEntity.getFirstName(), patientTO.getFirstName());
        assertEquals(patientEntity.getLastName(), patientTO.getLastName());
        assertEquals(patientEntity.getDateOfBirth(), patientTO.getDateOfBirth());

        assertEquals(patientEntity.isHasInsurance(), patientTO.isHasInsurance());

    }
    @Test
    public void testFindAllVisitsByPatientId() {
        // Given
        Long patientId = 1L;

        // When
        List<VisitEntity> visits = patientService.findAllVisitsByPatientId(patientId);

        // Then
        assertNotNull(visits);
        assertEquals(2, visits.size());
    }
}


