package com.tpajay.medicus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import com.tpajay.medicus.model.Patient;
import com.tpajay.medicus.model.PatientRecord;
import com.tpajay.medicus.service.PatientServiceInterface;

@Controller
public class PatientController {
	
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientServiceInterface patientService;
	
	//user security
	@Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
    
	//user security
    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;
	
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
	
	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public ModelAndView patient() {
		//viewname, modelname, modelObject
		return new ModelAndView("patient", "patient", new Patient());
	}	
		
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
	
	@RequestMapping(value = "/patientlist", method = RequestMethod.GET)
	public ModelAndView getPatientList() {
		List patientList = patientService.getPatientList();
		//viewname, modelname, modelObject
		return new ModelAndView("patientlist", "patientList", patientList);
	}
			
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
	
	@RequestMapping(value = "/deletePatient", method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam(value="id", required=true) int patientId) {
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
	 */
	
	//for REST: returns a patient in JSON
	//using: jackson-annotations, jackson-core, jackson-databind for JSON
	@RequestMapping(value="/patient/{id}", method = RequestMethod.GET )
	public ResponseEntity<Patient> getPatientAsJSONById(@PathVariable("id") Integer id) {
		Patient patient = patientService.getPatientById(id);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	//for REST: return patient list in JSON
	@RequestMapping(value= "/patients", method = RequestMethod.GET)
	public ResponseEntity<List<Patient>> getAllPatients() {
		List<Patient> list = patientService.getPatientList();
		return new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
	}	

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
		patientService.deletePatient(id);
        return "redirect:/patientlist";
    }
	
	
	///////////////////////////////////////////////////////////////////////////
	/////   The following methods are for user authentication / security  /////
	///////////////////////////////////////////////////////////////////////////

    // This method handles login GET requests.
    // If user is already logged-in and tries to goto login page again, will be redirected to list page.
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
        	//get the patient id to default patient to their patient details page
        	String loginId = SecurityContextHolder.getContext().getAuthentication().getName();
        	Patient patient = patientService.findByLoginId(loginId);
        	int pid = patient.getPatientId();
        	return "redirect:patientdetails?id=" + pid;
        }
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }
    
    // This method returns the principal[user-name] of logged-in user.
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
    
    // This method handles Access-Denied redirect.
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessDenied";
    }    
    
	private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }    
	

}//end class
