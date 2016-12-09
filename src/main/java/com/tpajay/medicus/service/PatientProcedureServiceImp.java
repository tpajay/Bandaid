package com.tpajay.medicus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpajay.medicus.dao.PatientDaoInterface;
import com.tpajay.medicus.dao.PatientProcedureDaoInterface;
import com.tpajay.medicus.model.PatientAllergy;
import com.tpajay.medicus.model.PatientProcedure;

/*
* Services Patient Medical Procedure related Data
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
* Website: http://tpajay.com [coming soon with working applications]
*/
@Service
public class PatientProcedureServiceImp implements PatientProcedureServiceInterface {
	
	@Autowired
	private PatientProcedureDaoInterface patientProcedureDao;

	public PatientProcedure getPatientProcedureById(int id) {
		PatientProcedure procedure = (PatientProcedure)patientProcedureDao.getPatientProcedureById(id);
		return procedure;
	}

	public List getPatientProcedureList(int id) {
		return patientProcedureDao.getPatientProcedureList(id);
	}

	public void savePatientProcedure(PatientProcedure procedure) {
		patientProcedureDao.savePatientProcedure(procedure);
	}

	public void updatePatientProcedure(PatientProcedure procedure) {
		// TODO Auto-generated method stub
		
	}

	public void deletePatientProcedure(int id) {
		patientProcedureDao.deletePatientProcedure(id);
	}
	
}
