package com.tpajay.medicus.dao;

import java.util.List;

import com.tpajay.medicus.model.PatientMedication;

public interface MedicationDaoInterface {

	public PatientMedication getById(int medicationId);
	
	public List getMedicationList();

	public void saveMedication(PatientMedication medication);

	public void updateMedication(PatientMedication medication);

	public void deleteMedication(PatientMedication medication);

	public void deleteMedication(int medicationId);
	
}
