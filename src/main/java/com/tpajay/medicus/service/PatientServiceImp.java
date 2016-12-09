package com.tpajay.medicus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tpajay.medicus.dao.PatientDaoInterface;
import com.tpajay.medicus.model.Patient;

/*
* Services Patient related Data
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
* Website: http://tpajay.com [coming soon with working applications]
*/
@Service
public class PatientServiceImp implements PatientServiceInterface {
	
	@Autowired
	private PatientDaoInterface patientHibernateDao;
	
    @Autowired
    private PasswordEncoder passwordEncoder;	
	
	public Patient getPatientById(int patientId) {
		Patient patient = (Patient)patientHibernateDao.getPatientById(patientId);
		System.out.println(">>> PatientServiceImp patientID: " + patient.getPatientId());
		System.out.println(">>> PatientServiceImp Record Count: " + patient.getRecords().size());
		return patient;
	}
	 
	public Patient getByName(String lastName, String firstName) {
		return patientHibernateDao.getByName(lastName, firstName);
	}
	
	public List getPatientList() {
		return patientHibernateDao.getPatientList();
	}
	 
	public void savePatient(Patient patient) {
		patient.setPassword(passwordEncoder.encode(patient.getPassword()));
		patientHibernateDao.savePatient(patient);
	}
	
	public void updatePatient(Patient patient) {
		patientHibernateDao.updatePatient(patient);
		//patientHibernateDao.merge(patient);
	}
	 
	public void deletePatient(Patient patient) {
		patientHibernateDao.deletePatient(patient);
	}
	
	public void deletePatient(int patientId) {
		patientHibernateDao.deletePatient(patientId);
	}
	
	//for security
    //loginId is currently the patients email address
    public Patient findByLoginId(String loginId) {
    	Patient patient = patientHibernateDao.findByLoginId(loginId);
        return patient;
    }	
	
}
