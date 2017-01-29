package com.tpajay.medicus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpajay.medicus.dao.PatientAllergyDaoInterface;
import com.tpajay.medicus.dao.PatientDaoInterface;
import com.tpajay.medicus.model.Patient;
import com.tpajay.medicus.model.PatientAllergy;

/*
* Services Allergy related Data
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
*/
@Service
public class PatientAllergyServiceImp implements PatientAllergyServiceInterface {
	
	@Autowired
	private PatientAllergyDaoInterface patientAllergyDao;

	public PatientAllergy getPatientAllergyById(int id) {
		PatientAllergy allergy = (PatientAllergy)patientAllergyDao.getPatientAllergyById(id);
		return allergy;
	}

	public List getPatientAllergyList(int id) {
		return patientAllergyDao.getPatientAllergyList(id);
	}

	public void savePatientAllergy(PatientAllergy allergy) {
		patientAllergyDao.savePatientAllergy(allergy);
	}

	public void updatePatientAllergy(PatientAllergy allergy) {
		// TODO Auto-generated method stub
		
	}

	public void deletePatientAllergy(int id) {
		patientAllergyDao.deletePatientAllergy(id);		
	}

	
}
