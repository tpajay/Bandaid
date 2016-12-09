package com.tpajay.medicus.service;

import java.util.List;

import com.tpajay.medicus.model.Patient;
import com.tpajay.medicus.model.PatientAppt;

public interface PatientApptServiceInterface {

	public PatientAppt getPatientApptById(int id);
	 
	public List getPatientApptList(int id);
	 
	public void savePatientAppt(PatientAppt appt);
	
	public void updatePatientAppt(PatientAppt appt);
	 
	public void deletePatientAppt(int id);
	
}

