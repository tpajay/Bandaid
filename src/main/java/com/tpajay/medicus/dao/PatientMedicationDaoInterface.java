package com.tpajay.medicus.dao;

import java.util.List;

import com.tpajay.medicus.model.PatientMedication;

public interface PatientMedicationDaoInterface {

	public PatientMedication getPatientMedicationById(int id);
	 
	public List getPatientMedicationList(int id);
	 
	public void savePatientMedication(PatientMedication med);
	
	public void updatePatientMedication(PatientMedication med);
	 
	public void deletePatientMedication(int id);
	
}
