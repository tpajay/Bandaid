package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REC_MEDHIST")
public class PatientRecordMedHist {

	@Id
	@GeneratedValue
	@Column(name="FORM_ID")
	private int formId;
	
	@Column(name="patient_id")
	private int patientId;

	//need to get patient name for view
	//@Transient
	//private String patientName;
	
	@Column(name="physician_id")
	private int physicianId;
	
	//need to get physician name for view
	//@Transient
	//private String physicianName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="height_ft")
	private String heightFt;
	
	@Column(name="height_in")
	private String heightInches;
	
	@Column(name="weight")
	private String weight;
	
	@Column(name="bmi")
	private String bmi;
	
	@Column(name="ethnicity")
	private String ethnicity;
	
	@Column(name="created_dttm")
	private String createdDttm; //need to make timestamp

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHeightFt() {
		return heightFt;
	}

	public void setHeightFt(String heightFt) {
		this.heightFt = heightFt;
	}

	public String getHeightInches() {
		return heightInches;
	}

	public void setHeightInches(String heightInches) {
		this.heightInches = heightInches;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getCreatedDttm() {
		return createdDttm;
	}

	public void setCreatedDttm(String createdDttm) {
		this.createdDttm = createdDttm;
	}
	
		
}
