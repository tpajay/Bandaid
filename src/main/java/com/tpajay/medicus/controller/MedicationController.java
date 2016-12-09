package com.tpajay.medicus.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tpajay.medicus.model.PatientMedication;
import com.tpajay.medicus.service.PatientMedicationServiceInterface;

/*
* Interface for DB operations for patient medications
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
* Website: http://tpajay.com [coming soon with working applications]
*/
@Controller
public class MedicationController {

	private static final Logger logger = LoggerFactory.getLogger(MedicationController.class);
	
	@Autowired
	private PatientMedicationServiceInterface medService;
	
	/* 
	 * REST methods to test Angular2 Components
	 * Will return JSON data back to the view
	 * using: jackson-annotations, jackson-core, jackson-databind for JSON
	 */
	
	//returns list of all medications for a patient - by patient id
	@RequestMapping(value= "/meds/{pid}", method = RequestMethod.GET)
	public ResponseEntity<List<PatientMedication>> getAllPatientMeds(@PathVariable("pid") Integer id) {
		List<PatientMedication> list = medService.getPatientMedicationList(id);
		return new ResponseEntity<List<PatientMedication>>(list, HttpStatus.OK);
	}
	
}
