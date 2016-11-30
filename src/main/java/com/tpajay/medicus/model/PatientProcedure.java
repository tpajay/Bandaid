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
	
}
