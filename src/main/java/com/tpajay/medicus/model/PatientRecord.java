package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This table holds a reference per patient to records
 * located in different tables.  The thought is an easy
 * way to add additional forms, per physician without having
 * to rewrite the main interface, model and view.
 * Use the entity name stored in this Class to determine
 * which form to load after user clicks form from page view.
 * 
 * @author  Jason Muse
 * LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
 * GitHub: https://github.com/tpajay
 */
@Entity
@Table(name="PATIENT_RECORD")
public class PatientRecord  implements Comparable<PatientRecord> {

	@Id
	@Column(name="PATIENT_RECORD_ID")
	private int patientRecordId;
	
	@Column(name="PATIENT_ID")
	private int patientId;
	
	//@ManyToOne
	//@JoinColumn(name = "patient_id")
	//private Patient patient;
	
	@Column(name="physician_id")
	private int physicianId;
	
	//The formid of the record in the appropriate table
	@Column(name="form_id")
	private int formId;
	
	//Entity to use to get data, the table to use
	@Column(name="entity")
	private String entity;
	
	//Used to display the form type on the main screen
	@Column(name="form_display_name")
	private String formDisplayName;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/*
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	*/

	public int getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(int physicianId) {
		this.physicianId = physicianId;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getFormDisplayName() {
		return formDisplayName;
	}

	public void setFormDisplayName(String formDisplayName) {
		this.formDisplayName = formDisplayName;
	}	
	
	public int getPatientRecordId() {
		return patientRecordId;
	}

	public void setPatientRecordId(int patientRecordId) {
		this.patientRecordId = patientRecordId;
	}

	public int compareTo(PatientRecord prec) {
		// compareTo should:
		//   return < 0 if this is supposed to be less than other
		//   return > 0 if this is supposed to be greater than other
        //   return 0 if they are supposed to be equal
        
		//sort by form display name
		int formName = this.formDisplayName.compareTo(prec.formDisplayName);
        return formName == 0 ? this.formDisplayName.compareTo(prec.formDisplayName) : formName;
	}
	
		
}
