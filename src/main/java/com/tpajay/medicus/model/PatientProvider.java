package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT_PROVIDER")
public class PatientProvider {

	@Id
	@Column(name="PATIENT_ID")
	private int patientId;
	
	@Column(name="provider_id")
	private int providerId;
	
}
