package com.tpajay.medicus.service;

import java.util.List;

import com.tpajay.medicus.model.PatientAllergy;

public interface PatientAllergyServiceInterface {

	public PatientAllergy getPatientAllergyById(int id);
	 
	public List getPatientAllergyList(int id);
	 
	public void savePatientAllergy(PatientAllergy allergy);
	
	public void updatePatientAllergy(PatientAllergy allergy);
	 
	public void deletePatientAllergy(int id);
	
}
