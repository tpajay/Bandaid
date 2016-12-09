package com.tpajay.medicus.dao;

import java.util.List;

import com.tpajay.medicus.model.PatientAppt;

public interface PatientApptDaoInterface {

	public PatientAppt getPatientApptById(int id);
	 
	public List getPatientApptList(int id);
	 
	public void savePatientAppt(PatientAppt appt);
	
	public void updatePatientAppt(PatientAppt appt);
	 
	public void deletePatientAppt(int id);
}
