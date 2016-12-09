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

import com.tpajay.medicus.model.PatientProvider;
import com.tpajay.medicus.service.PatientProviderServiceInterface;

/*
* Interface for DB operations for providers and retrieve the patients provider
* 
* @author  Jason Muse
*/
@Controller
public class ProviderController {

	private static final Logger logger = LoggerFactory.getLogger(ProviderController.class);
	
	@Autowired
	private PatientProviderServiceInterface providerService;
	
	/* 
	 * REST methods to test Angular2 Components
	 * Will return JSON data back to the view
	 * using: jackson-annotations, jackson-core, jackson-databind for JSON
	 */
	
	//returns list of all patients by patient id
	//returns the complete patient list
	@RequestMapping(value= "/providers/{pid}", method = RequestMethod.GET)
	public ResponseEntity<List<PatientProvider>> getAllPatientProviders(@PathVariable("pid") Integer id) {
		List<PatientProvider> list = providerService.getPatientProviderList(id);
		return new ResponseEntity<List<PatientProvider>>(list, HttpStatus.OK);
	}
	
}
