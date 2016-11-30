package com.tpajay.medicus.dao;

import java.util.List;

import com.tpajay.medicus.model.PatientAllergy;

public interface AllergyDaoInterface {

	public PatientAllergy getById(int allergyId);
	
	public List getAllergyList();

	public void saveAllergy(PatientAllergy allergy);

	public void updateAllergy(PatientAllergy allergy);

	public void deleteAllergy(PatientAllergy allergy);

	public void deleteAllergy(int allergyId);
	
}
