package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="REC_AUTH_MEDREL_OUT")
public class PatientRecordMedRelOut {

	@Id
	@GeneratedValue
	@Column(name="FORM_ID")
	private int formId;
	
}