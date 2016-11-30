package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT_ALLERGY")
public class PatientAllergy {

	@Id
	@GeneratedValue
	@Column(name="ALLERGY_ID")
	private int allergyId;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="danger_level")
	private String dangerLevel;
	
	@Column(name="solution")
	private String solution;
	
	@Column(name="created_dttm")
	private String createdDttm;
	
}
