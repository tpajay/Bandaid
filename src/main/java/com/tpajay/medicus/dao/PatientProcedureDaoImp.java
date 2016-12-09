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

import com.tpajay.medicus.model.PatientProcedure;

/*
* Database opertaions for: Patient Procedures
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
* Website: http://tpajay.com [coming soon with working applications]
*/
//@Component
@Repository
@Transactional
public class PatientProcedureDaoImp implements PatientProcedureDaoInterface {

	static final Logger logger = LoggerFactory.getLogger(PatientDaoHibernateImp.class);

	@Autowired
	SessionFactory sessionFactory;

	//return a single medical procedure for a patient
	@Transactional(readOnly = true)
	public PatientProcedure getPatientProcedureById(int id) {
		Session session = sessionFactory.getCurrentSession();
		PatientProcedure procedure = (PatientProcedure)session.get(PatientProcedure.class, id);		
		return procedure;
	}
	
	//return a list of all patients medical procedures
	public List<PatientProcedure> getPatientProcedureList(int id) {
		@SuppressWarnings("unchecked")
        List<PatientProcedure> resultList = (List<PatientProcedure>) sessionFactory.getCurrentSession()
                .createCriteria(PatientProcedure.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		logger.info(">>>>>> getPatientProcedureList list size: " + resultList.size());
		return resultList;
	 }
	
	//[TODO] need to add method to return all procedures for a given date/time range

	public void savePatientProcedure(PatientProcedure procedure) {
		// TODO Auto-generated method stub
		
	}

	public void updatePatientProcedure(PatientProcedure procedure) {
		// TODO Auto-generated method stub
		
	}

	public void deletePatientProcedure(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
} //end class
