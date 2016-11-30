package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT_APPT")
public class PatientAppt {

	@Id
	@GeneratedValue
	@Column(name="APPT_ID")
	private int apptId;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="physician_id")
	private int physicianId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="appt_dttm")
	private String apptDttm;
	
	@Column(name="created_dttm")
	private String createdDttm;
	
}
