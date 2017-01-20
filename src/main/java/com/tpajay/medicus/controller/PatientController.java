package com.tpajay.medicus.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tpajay.medicus.model.Patient;
import com.tpajay.medicus.model.PatientRecord;
import com.tpajay.medicus.service.PatientServiceInterface;

/*
* Interface for DB operations for patient data, patient details,
* adding new patients, retrieving all patients[patients list,
* and REST methods that return JSON data for Angular front-end.
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
* Website: http://tpajay.com [coming soon with working applications]
*/
@Controller
public class PatientController {
	
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientServiceInterface patientService;
	
	//for form validation
	//bean defined in hibernate.xml file
	@Autowired
	@Qualifier("patientValidator")
	private Validator validator;
	
	//for form validation
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	//return 
	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public ModelAndView patient() {
		//viewname, modelname, modelObject
		return new ModelAndView("patient", "patient", new Patient());
	}	
		
	//returns a patients details: Patient and Patient Records
	@RequestMapping(value = "/patientdetails", method = RequestMethod.GET)
	public Patient getPatientById(@RequestParam(value="id", required=true) int id) {
		logger.info(">>> PatientController id: " + id);
		Patient patient = (Patient)patientService.getPatientById(id);		
		
		//verify patient and records
		logger.info(">>> PatientController patient id: " + patient.getPatientId());
		Set<PatientRecord> patientRecords = patient.getRecords();
		java.util.Iterator<PatientRecord> iter = patientRecords.iterator();
		while (iter.hasNext()){
			PatientRecord prec = (PatientRecord)iter.next();
			logger.info(">>> Patient Record: " + prec.getFormDisplayName());
		}
		
		//returns to patientdetails.jsp (/patientdetails)
		return patient;
	}
	
	//returns list of all patients
	@RequestMapping(value = "/patientlist", method = RequestMethod.GET)
	public ModelAndView getPatientList() {
		List patientList = patientService.getPatientList();
		//viewname, modelname, modelObject
		return new ModelAndView("patientlist", "patientList", patientList);
	}
	
	//Called when submitting a new Patient Form, contains form Validations
	//using a Validator class.
	@RequestMapping(value = "/addpatient", method = RequestMethod.POST)
	public String savePatient(
			@ModelAttribute("patient") @Validated Patient patient,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			logger.info("Patient Form Errors: returning to view.");
			return "patient";
		}
		patientService.savePatient(patient);
		model.addAttribute("patient", patient);
		//return "patientsuccess";
		return "redirect:/patientlist";
	}	
	
	//[TODO] Delete a patient from the database and records from all tables.
	@RequestMapping(value = "/deletePatient", method = RequestMethod.GET)
	public String deletePatient(@RequestParam(value="id", required=true) int patientId) {
		//get the customer first using ID
		Patient patient = (Patient)patientService.getPatientById(patientId);
		
		//check patient record listing
		Set precs = patient.getRecords();
		java.util.Iterator iter = precs.iterator();
		while (iter.hasNext()){
			PatientRecord prec = (PatientRecord)iter.next();
			logger.info(">>> patient record form id: " + prec.getFormId());
		}
		
		patientService.deletePatient(patient);
        return "redirect:/patientlist";
	}
	
	
	/* 
	 * REST methods to test Angular2 Components
	 * Will return JSON data back to the view
	 * using: jackson-annotations, jackson-core, jackson-databind for JSON
	 */
	
	//returns a certain patient using the patient_id
	@RequestMapping(value="/patient/{id}", method = RequestMethod.GET )
	public ResponseEntity<Patient> getPatientAsJSONById(@PathVariable("id") Integer id) {
		Patient patient = patientService.getPatientById(id);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	//returns the complete patient list
	@RequestMapping(value= "/patients", method = RequestMethod.GET)
	public ResponseEntity<List<Patient>> getAllPatients() {
		List<Patient> list = patientService.getPatientList();
		return new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
	}	

	//[TODO] delete a patient
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
		patientService.deletePatient(id);
        return "redirect:/patientlist";
    }
	
	
}//end class
