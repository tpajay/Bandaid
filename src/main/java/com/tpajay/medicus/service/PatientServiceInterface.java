package com.tpajay.medicus.service;

import java.util.List;

import com.tpajay.medicus.model.Patient;

public interface PatientServiceInterface {

	public Patient getPatientById(int patientId);
	 
	public Patient getByName(String lastName, String firstName);
	
	public List getPatientList();
	 
	public void savePatient(Patient patient);
	
	public void updatePatient(Patient patient);
	 
	public void deletePatient(Patient patient);
	
	public void deletePatient(int patientId);
	
	public Patient findByLoginId(String loginId);
	
}
