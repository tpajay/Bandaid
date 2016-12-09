package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* Patient Medical History Release Form, allows other doctors to release history
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
* Website: http://tpajay.com [coming soon with working applications]
*/
@Entity
@Table(name="REC_AUTH_MEDREL_IN")
public class PatientRecordMedRelIn {

	@Id
	@GeneratedValue
	@Column(name="FORM_ID")
	private int formId;
	
}
