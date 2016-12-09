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
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
* Website: http://tpajay.com [coming soon with working applications]
*/
@Controller
public class PhysicianController {

	private static final Logger logger = LoggerFactory.getLogger(PhysicianController.class);
	
	//@Autowired
	//private PhysicianServiceInterface physicianService;
	
	/* 
	 * REST methods to test Angular2 Components
	 * Will return JSON data back to the view
	 * using: jackson-annotations, jackson-core, jackson-databind for JSON
	 */
	
	//returns list of all physicians
	/*
	@RequestMapping(value= "/physicians", method = RequestMethod.GET)
	public ResponseEntity<List<Physician>> getAllPhysicians() {
		List<Physician> list = physicianService.getPhysicianList();
		return new ResponseEntity<List<Physician>>(list, HttpStatus.OK);
	}
	*/
	
}
