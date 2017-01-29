package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
* Patient Medical History Release Form, allows sharing of medical history
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
*/
//@Entity
//@Table(name="REC_AUTH_MEDREL_OUT")
public class PatientRecordMedRelOut {

	@Id
	@GeneratedValue
	@Column(name="FORM_ID")
	private int formId;
	
}
