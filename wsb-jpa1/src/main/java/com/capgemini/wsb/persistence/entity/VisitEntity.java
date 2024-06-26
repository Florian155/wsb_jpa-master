package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="doctor_id")
	private  DoctorEntity doctor;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private  PatientEntity patient;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "VISIT_MEDICAL_TREATMENT_MAPPING",
			joinColumns = @JoinColumn(name = "visit_id"),
			inverseJoinColumns = @JoinColumn(name = "medical_treatment_id"))
	private List<MedicalTreatmentEntity> medicalTreatments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
}
