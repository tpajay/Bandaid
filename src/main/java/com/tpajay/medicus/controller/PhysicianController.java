package com.tpajay.medicus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tpajay.medicus.service.PatientServiceInterface;

/*
* Interface for CRUD operations to add, delete, update Physicians
* 
* @author  Jason Muse
*/
@Controller
public class PhysicianController {

	private static final Logger logger = LoggerFactory.getLogger(PhysicianController.class);
	
	@Autowired
	private PatientServiceInterface allergyService;
	
	/* 
	 * REST methods to test Angular2 Components
	 * Will return JSON data back to the view
	 * using: jackson-annotations, jackson-core, jackson-databind for JSON
	 */
	
	//returns list of all patients by patient id
	//returns the complete patient list
	/*
	@RequestMapping(value= "/allergy/{pid}", method = RequestMethod.GET)
	public ResponseEntity<List<PatientAllergy>> getAllPatients() {
		List<PatientAllergy> list = allergyService.getPatientList();
		return new ResponseEntity<List<PatientAllergy>>(list, HttpStatus.OK);
	}
	*/
	
}
