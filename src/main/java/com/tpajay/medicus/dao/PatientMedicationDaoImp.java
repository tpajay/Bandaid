package com.tpajay.medicus.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tpajay.medicus.model.PatientMedication;

/*
* Database opertaions for: Patient Medications
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
*/
//@Component
@Repository
@Transactional
public class PatientMedicationDaoImp implements PatientMedicationDaoInterface {

	static final Logger logger = LoggerFactory.getLogger(PatientDaoHibernateImp.class);

	@Autowired
	SessionFactory sessionFactory;

	//return a single medication for a patient
	@Transactional(readOnly = true)
	public PatientMedication getPatientMedicationById(int id) {
		Session session = sessionFactory.getCurrentSession();
		PatientMedication med = (PatientMedication)session.get(PatientMedication.class, id);		
		return med;
	}
	
	//return a list of all patient medications
	public List<PatientMedication> getPatientMedicationList(int id) {
		@SuppressWarnings("unchecked")
        List<PatientMedication> resultList = (List<PatientMedication>) sessionFactory.getCurrentSession()
                .createCriteria(PatientMedication.class)
                .add( Restrictions.eq( "patientId", id) )
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		logger.info(">>>>>> getPatientMedicationList list size: " + resultList.size());
		return resultList;
	 }	

	public void savePatientMedication(PatientMedication med) {
		// TODO Auto-generated method stub
		
	}

	public void updatePatientMedication(PatientMedication med) {
		// TODO Auto-generated method stub
		
	}

	public void deletePatientMedication(int id) {
		// TODO Auto-generated method stub
		
	}

} //end class
