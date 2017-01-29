package com.tpajay.medicus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpajay.medicus.dao.PatientDaoInterface;
import com.tpajay.medicus.dao.PatientProviderDaoInterface;
import com.tpajay.medicus.model.PatientAllergy;
import com.tpajay.medicus.model.PatientProvider;

/*
* Services Provider related Data
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
*/
@Service
public class PatientProviderServiceImp implements PatientProviderServiceInterface {
	
	@Autowired
	private PatientProviderDaoInterface patientProviderDao;

	public PatientProvider getPatientProviderById(int id) {
		PatientProvider provider = (PatientProvider)patientProviderDao.getPatientProviderById(id);
		return provider;
	}

	public List getPatientProviderList(int id) {
		return patientProviderDao.getPatientProviderList(id);
	}

	public void savePatientProvider(PatientProvider provider) {
		patientProviderDao.savePatientProvider(provider);
	}

	public void updatePatientProvider(PatientProvider provider) {
		// TODO Auto-generated method stub
		
	}

	public void deletePatientProvider(int id) {
		patientProviderDao.deletePatientProvider(id);
	}
	
}
