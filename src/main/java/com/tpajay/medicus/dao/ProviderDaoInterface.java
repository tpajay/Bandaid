package com.tpajay.medicus.dao;

import java.util.List;

import com.tpajay.medicus.model.PatientProvider;

public interface ProviderDaoInterface {

	public PatientProvider getById(int providerId);
	
	public List getProviderList();

	public void saveProvider(PatientProvider provider);

	public void updateProvider(PatientProvider provider);

	public void deleteProvider(PatientProvider provider);

	public void deleteProvider(int providerId);
	
}
