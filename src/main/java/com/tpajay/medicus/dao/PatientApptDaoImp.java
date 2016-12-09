package com.tpajay.medicus.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tpajay.medicus.model.PatientAppt;

//@Component
@Repository
@Transactional
public class PatientApptDaoImp implements PatientApptDaoInterface {

	static final Logger logger = LoggerFactory.getLogger(PatientDaoHibernateImp.class);

	@Autowired
	SessionFactory sessionFactory;

	//return a single appt for a patient
	@Transactional(readOnly = true)
	public PatientAppt getPatientApptById(int id) {
		Session session = sessionFactory.getCurrentSession();
		PatientAppt appt = (PatientAppt)session.get(PatientAppt.class, id);		
		return appt;
	}
	
	//return a list of all patient appts
	public List<PatientAppt> getPatientApptList(int id) {
		@SuppressWarnings("unchecked")
        List<PatientAppt> resultList = (List<PatientAppt>) sessionFactory.getCurrentSession()
                .createCriteria(PatientAppt.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		logger.info(">>>>>> getPatientApptList list size: " + resultList.size());
		return resultList;
	 }
	
	//[TODO] add method to return appts in a date/time range

	public void savePatientAppt(PatientAppt appt) {
		// TODO Auto-generated method stub
		
	}

	public void updatePatientAppt(PatientAppt appt) {
		// TODO Auto-generated method stub
		
	}

	public void deletePatientAppt(int id) {
		// TODO Auto-generated method stub
		
	}
	
} //end class
