package com.tpajay.medicus.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tpajay.medicus.model.Patient;
import com.tpajay.medicus.model.PatientRecord;

/*
* Database opertaions for: Patients
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
*/
//@Component
@Repository
@Transactional
public class PatientDaoHibernateImp implements PatientDaoInterface {
	
	static final Logger logger = LoggerFactory.getLogger(PatientDaoHibernateImp.class);

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(readOnly = true)
	public Patient getPatientById(int patientId) {
		Session session = sessionFactory.getCurrentSession();
		Patient patient = (Patient)session.get(Patient.class, patientId);		
		// future reference: had to add PatientRecord recordid @Id to ensure all rows where in Set
		// using OneToMany in Patient Class so no need to get records separately
		//Set<PatientRecord> precsSet = getRecordsById(patientId);
		//patient.setRecords(precsSet);
		return patient;
	}
	
	//Patient Records by patient ID.  
	//Returns the patients records as java.util.Set sorted by Form Display Name
	@Transactional(readOnly = true)
	public Set<PatientRecord> getRecordsById(int pid) {
		logger.info(">>> PatientDaoHibernateImp getRecordsById pid: " + pid);
        List<PatientRecord> patientRecords = (List<PatientRecord>) sessionFactory.getCurrentSession()
                .createCriteria(PatientRecord.class)
                .add(Restrictions.eq("patientId", pid))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();        

        //convert List to sorted Set by form display name
        //should change this to sort by date, latest on top
        //see PatientRecord compareTo
        Set<PatientRecord> prSet = new TreeSet<PatientRecord>(patientRecords);
		logger.info(">>>>>> PatientDaoHibernateImp getRecordsById prSet size: " + prSet.size());
        for (PatientRecord x : prSet) {
        	System.out.println(x.getFormDisplayName());
        	System.out.println(x.hashCode());
        }
		return prSet;
	}	
	 
	@Transactional(readOnly = true)
	public Patient getByName(String lastName, String firstName) {
		return (Patient) sessionFactory.getCurrentSession()
		.createQuery("from patient p where p.firstname = :fname and p.lastname = :lname")		
		.setParameter("fname", firstName)
		.setParameter("lname", lastName)
		.uniqueResult();
	}
	
	public List getPatientList() {
		@SuppressWarnings("unchecked")
        List<Patient> patientList = (List<Patient>) sessionFactory.getCurrentSession()
                .createCriteria(Patient.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		logger.info(">>>>>> PatientDaoHibernateImp patientList size: " + patientList.size());
		return patientList;
	 }
	
	/* for security logins
	 * using patient email address for loginID
	 */
    public Patient findByLoginId(String loginId) {
        logger.info("PatientDaoHibernateImp Users login id: {}", loginId);
        Patient patient = (Patient) sessionFactory.getCurrentSession()
                .createCriteria(Patient.class)
                .add(Restrictions.eq("email", loginId))
                .uniqueResult();
        return patient;
    }	
	 
	public void savePatient(Patient patient) {
		sessionFactory.getCurrentSession().merge(patient);
	}
	
	public void updatePatient(Patient patient) {
		sessionFactory.getCurrentSession().save(patient);
	}
	
	public void deletePatient(Patient patient) {
		sessionFactory.getCurrentSession().delete(patient);
	}
	
	//delete by passing an patient ID
	public void deletePatient(int patientId) {
		Session session = sessionFactory.getCurrentSession();
		Patient patient = (Patient)session.get(Patient.class, patientId);
		if (patient != null)
			sessionFactory.getCurrentSession().delete(patient);
	}

}
