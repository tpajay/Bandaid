package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT_MEDICATION")
public class PatientMedication {

	@Id
	@GeneratedValue
	@Column(name="PRESC_ID")
	private int prescId;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="physician_id")
	private int physicianId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="dosage")
	private String dosage;
	
	@Column(name="interval")
	private String inerval;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="start_dttm")
	private String startDttm;
	
	@Column(name="end_dttm")
	private String endDttm;
	
	@Column(name="created_dttm")
	private String createdDttm;
	
}
