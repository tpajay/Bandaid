package com.tpajay.medicus.service;

import java.util.List;

import com.tpajay.medicus.model.PatientProcedure;

public interface PatientProcedureServiceInterface {

	public PatientProcedure getPatientProcedureById(int id);
	 
	public List getPatientProcedureList(int id);
	 
	public void savePatientProcedure(PatientProcedure procedure);
	
	public void updatePatientProcedure(PatientProcedure procedure);
	 
	public void deletePatientProcedure(int id);
}
