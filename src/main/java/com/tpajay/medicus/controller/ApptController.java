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

import com.tpajay.medicus.model.PatientAppt;
import com.tpajay.medicus.service.PatientApptServiceInterface;

/*
* Interface for DB operations for patient appointments
* 
* @author  Jason Muse
*/
@Controller
public class ApptController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApptController.class);
	
	@Autowired
	private PatientApptServiceInterface apptService;
	
	/* 
	 * REST methods to test Angular2 Components
	 * Will return JSON data back to the view
	 * using: jackson-annotations, jackson-core, jackson-databind for JSON
	 */
	
	//returns list of all patients by patient id
	//returns the complete patient list
	@RequestMapping(value= "/appts/{pid}", method = RequestMethod.GET)
	public ResponseEntity<List<PatientAppt>> getAllPatientAppts(@PathVariable("pid") Integer id) {
		List<PatientAppt> list = apptService.getPatientApptList(id);
		return new ResponseEntity<List<PatientAppt>>(list, HttpStatus.OK);
	}
	
}
