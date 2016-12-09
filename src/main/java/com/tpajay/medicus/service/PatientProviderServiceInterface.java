package com.tpajay.medicus.service;

import java.util.List;

import com.tpajay.medicus.model.PatientProvider;

public interface PatientProviderServiceInterface {

	public PatientProvider getPatientProviderById(int id);
	 
	public List getPatientProviderList(int id);
	 
	public void savePatientProvider(PatientProvider provider);
	
	public void updatePatientProvider(PatientProvider provider);
	 
	public void deletePatientProvider(int id);
}
