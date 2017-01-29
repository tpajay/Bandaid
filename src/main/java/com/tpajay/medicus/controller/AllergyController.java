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

import com.tpajay.medicus.model.PatientAllergy;
import com.tpajay.medicus.service.PatientAllergyServiceInterface;

/*
* Interface for DB operations for allergies list and patient allergies
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
*/
@Controller
public class AllergyController {

	private static final Logger logger = LoggerFactory.getLogger(AllergyController.class);
	
	@Autowired
	private PatientAllergyServiceInterface allergyService;
	
	/* 
	 * REST methods to test Angular2 Components
	 * Will return JSON data back to the view
	 * using: jackson-annotations, jackson-core, jackson-databind for JSON
	 */
	
	//returns list of all allergies for a patient - by patient id
	@RequestMapping(value= "/allergies/{pid}", method = RequestMethod.GET)
	public ResponseEntity<List<PatientAllergy>> getAllPatientAllergies(@PathVariable("pid") Integer id) {
		List<PatientAllergy> list = allergyService.getPatientAllergyList(id);
		return new ResponseEntity<List<PatientAllergy>>(list, HttpStatus.OK);
	}
	
	
	//return a single allergy using allergy id
	/*
	@RequestMapping(value="/allergy/{id}", method = RequestMethod.GET )
	public ResponseEntity<PatientAllergy> getPatientAllergy(@PathVariable("pid") Integer id) {
		PatientAllergy allergy = allergyService.getPatientAllergyById(id);
		return new ResponseEntity<PatientAllergy>(allergy, HttpStatus.OK);
	}
	*/
	
	//[TODO] add new patient allergy
	/*
	@RequestMapping(value = "/allergy/", method = RequestMethod.POST)
	public ResponseEntity<Void> createPatientAllergy(@RequestBody PatientAllergy allergy, UriComponentsBuilder ucBuilder) {
		logger.info("In createPatientAllergy, allergy name = " + allergy.getName());
		if (allergyService.isAllergyExist(allergy)) {
			System.out.println("Allergy with name " + allergy.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		allergyService.saveAllergy(allergy);
		return new ResponseEntity<Patient>(allergy, HttpStatus.OK);
	}
	*/
	
	//[TODO] delete a patient allergy
	/*
	@RequestMapping("/delete/{pid}")
	public String deletePatientAllergy(@PathVariable("id") int id){
		logger.info("In delete allergy, id = " + id);
		allergyService.deleteAllergy(id);
		return new ResponseEntity<Patient>(allergy, HttpStatus.OK);
    }
    */

}
