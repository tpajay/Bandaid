package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* Patient Insurance Provider
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
*/
@Entity
@Table(name="PATIENT_PROVIDER")
public class PatientProvider {

	@Id
	@Column(name="PATIENT_ID")
	private int patientId;
	
	@Column(name="provider_id")
	private int providerId;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	
	
	
}
