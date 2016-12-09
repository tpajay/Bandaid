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

import com.tpajay.medicus.model.PatientAllergy;

/*
* Database opertaions for: Allergies and Patient Allergies
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
* Website: http://tpajay.com [coming soon with working applications]
*/
//@Component
@Repository
@Transactional
public class PatientAllergyDaoImp implements PatientAllergyDaoInterface {

	static final Logger logger = LoggerFactory.getLogger(PatientDaoHibernateImp.class);

	@Autowired
	SessionFactory sessionFactory;

	//return a single allergy by id for a patient
	@Transactional(readOnly = true)
	public PatientAllergy getPatientAllergyById(int id) {
		Session session = sessionFactory.getCurrentSession();
		PatientAllergy allergy = (PatientAllergy)session.get(PatientAllergy.class, id);		
		return allergy;
	}
	
	//return a patients list of allergies
	public List<PatientAllergy> getPatientAllergyList(int id) {
		@SuppressWarnings("unchecked")
        List<PatientAllergy> resultList = (List<PatientAllergy>) sessionFactory.getCurrentSession()
                .createCriteria(PatientAllergy.class)
                .add( Restrictions.eq( "patientId", id) )
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		logger.info(">>>>>> getPatientAllergyList list size: " + resultList.size());
		return resultList;
	 }	

	public void savePatientAllergy(PatientAllergy allergy) {
		// TODO Auto-generated method stub
		
	}

	public void updatePatientAllergy(PatientAllergy allergy) {
		// TODO Auto-generated method stub
		
	}

	public void deletePatientAllergy(int id) {
		// TODO Auto-generated method stub
		
	}
	
} //end class
