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

	public int getApptId() {
		return apptId;
	}

	public void setApptId(int apptId) {
		this.apptId = apptId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(int physicianId) {
		this.physicianId = physicianId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApptDttm() {
		return apptDttm;
	}

	public void setApptDttm(String apptDttm) {
		this.apptDttm = apptDttm;
	}

	public String getCreatedDttm() {
		return createdDttm;
	}

	public void setCreatedDttm(String createdDttm) {
		this.createdDttm = createdDttm;
	}
	
	
	
}
