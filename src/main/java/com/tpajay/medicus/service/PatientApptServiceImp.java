package com.tpajay.medicus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpajay.medicus.dao.PatientApptDaoInterface;
import com.tpajay.medicus.dao.PatientDaoInterface;
import com.tpajay.medicus.model.PatientAllergy;
import com.tpajay.medicus.model.PatientAppt;

/*
* Services Patient Appointment related Data
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
*/
@Service
public class PatientApptServiceImp implements PatientApptServiceInterface {
	
	@Autowired
	private PatientApptDaoInterface patientApptDao;

	public PatientAppt getPatientApptById(int id) {
		PatientAppt appt = (PatientAppt)patientApptDao.getPatientApptById(id);
		return appt;
	}

	public List getPatientApptList(int id) {
		return patientApptDao.getPatientApptList(id);
	}

	public void savePatientAppt(PatientAppt appt) {
		patientApptDao.savePatientAppt(appt);
	}

	public void updatePatientAppt(PatientAppt appt) {
		// TODO Auto-generated method stub
		
	}

	public void deletePatientAppt(int id) {
		patientApptDao.deletePatientAppt(id);
	}

}
