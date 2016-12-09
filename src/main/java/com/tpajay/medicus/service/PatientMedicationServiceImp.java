package com.tpajay.medicus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpajay.medicus.dao.PatientDaoInterface;
import com.tpajay.medicus.dao.PatientMedicationDaoInterface;
import com.tpajay.medicus.model.PatientAllergy;
import com.tpajay.medicus.model.PatientMedication;

/*
* Services Patient Medication related Data
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
* Website: http://tpajay.com [coming soon with working applications]
*/
@Service
public class PatientMedicationServiceImp implements PatientMedicationServiceInterface {
	
	@Autowired
	private PatientMedicationDaoInterface patientMedicationDao;

	public PatientMedication getPatientMedicationById(int id) {
		PatientMedication med = (PatientMedication)patientMedicationDao.getPatientMedicationById(id);
		return med;
	}

	public List getPatientMedicationList(int id) {
		return patientMedicationDao.getPatientMedicationList(id);
	}

	public void savePatientMedication(PatientMedication med) {
		patientMedicationDao.savePatientMedication(med);
	}

	public void updatePatientMedication(PatientMedication med) {
		// TODO Auto-generated method stub
		
	}

	public void deletePatientMedication(int id) {
		patientMedicationDao.deletePatientMedication(id);
	}
	
}
