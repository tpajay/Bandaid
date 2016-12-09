package com.tpajay.medicus.dao;

import java.util.List;

import com.tpajay.medicus.model.PatientAllergy;

public interface PatientAllergyDaoInterface {

	public PatientAllergy getPatientAllergyById(int id);
	 
	public List getPatientAllergyList(int id);
	 
	public void savePatientAllergy(PatientAllergy allergy);
	
	public void updatePatientAllergy(PatientAllergy allergy);
	 
	public void deletePatientAllergy(int id);
	
}
