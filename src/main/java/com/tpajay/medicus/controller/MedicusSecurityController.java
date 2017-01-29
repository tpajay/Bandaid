package com.tpajay.medicus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tpajay.medicus.model.Patient;
import com.tpajay.medicus.service.PatientServiceInterface;

/*
* Used for application security using Spring Security PersistentTokenBasedRememberMeServices 
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
*/
@Controller
public class MedicusSecurityController {
	
	private static final Logger logger = LoggerFactory.getLogger(MedicusSecurityController.class);
	
	//[TODO] Currently using a method in the PatientServiceInterface class to lookup a patient login id
	@Autowired
	private PatientServiceInterface patientService;
	
	//user security
	@Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
    
	//user security
    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;
	

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
