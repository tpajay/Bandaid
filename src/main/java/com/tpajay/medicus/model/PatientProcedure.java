package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT_PROCEDURE")
public class PatientProcedure {

	@Id
	@GeneratedValue
	@Column(name="PROCEDURE_ID")
	private int procedureId;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="physician_id")
	private int physicianId;
	
	@Column(name="description")
	private String description;

	@Column(name="postproceduredetails")
	private String postProcedureDetails;
	
	@Column(name="scheduled_dttm")
	private String scheduledDttm;
	
	@Column(name="completed_dttm")
	private String completedDttm;
	
	@Column(name="created_dttm")
	private String createdDttm;

	public int getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(int procedureId) {
		this.procedureId = procedureId;
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

	public String getPostProcedureDetails() {
		return postProcedureDetails;
	}

	public void setPostProcedureDetails(String postProcedureDetails) {
		this.postProcedureDetails = postProcedureDetails;
	}

	public String getScheduledDttm() {
		return scheduledDttm;
	}

	public void setScheduledDttm(String scheduledDttm) {
		this.scheduledDttm = scheduledDttm;
	}

	public String getCompletedDttm() {
		return completedDttm;
	}

	public void setCompletedDttm(String completedDttm) {
		this.completedDttm = completedDttm;
	}

	public String getCreatedDttm() {
		return createdDttm;
	}

	public void setCreatedDttm(String createdDttm) {
		this.createdDttm = createdDttm;
	}
	
	
	
}
