package com.tpajay.medicus.validator;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tpajay.medicus.model.Patient;
 
/*
* Validator for the Patient form.
* Testing using Regular Expression, Pattern/Matcher
* and using message properties file that contains the text
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
*/
public class PatientFormValidator implements Validator {
	
	public boolean supports(Class<?> paramClass) {
		return Patient.class.equals(paramClass);
	}
	
	public void validate(Object obj, Errors errors) {
		
		Patient patient = (Patient) obj;
		
		//Simple validation to make sure first name, last name and email are not empty
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameFirst", "patient.nameFirst.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameLast", "patient.nameLast.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "patient.email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "patient.password.required");
		
		
		/*
		 * Example of validating a date string (09-20-2016 01:00) using REGEX to 
		 * ensure making sure it is not null, and a valid date (future date, leap year, 
		 * in range of 12mos, 31 or less days, under 24hrs, 59mins, etc)
		 */
		String value = null;
		//value = "09-20-2016 01:00";
		value = patient.getDueDttm();		
		
	    if (value == null || value.length() < 1){
	      errors.rejectValue("dueDttm","patient.duedttm.nullerror");
	    }

		if (value != null && value.length() > 0){

			//check if Date pattern is valid
			boolean isValid = false;

		    //second, check to make sure date entered follows pattern
	    	Pattern p1 = Pattern.compile("\\b\\d{2}-\\d{2}-\\d{4}\\s\\d{2}:\\d{2}\\b"); // ex:01-01-2004 01:00
		    Pattern p2 = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\s\\d{2}:\\d{2}\\b"); // ex:01/01/2004 01:00
		    Matcher m1 = p1.matcher(value);
		    Matcher m2 = p2.matcher(value);

		  	if (m1.matches()){
		  		isValid = true;
		  	}else if (m2.matches()){
		  		isValid = true;
		  	}else{
		  		errors.rejectValue("dueDttm","patient.duedttm.error.datetimeformaterror");
		  	}

		  	if(isValid){
			  	//third, make sure date is valid (not > 31days, not > 12 months, etc..)
				String dddt_month = value.substring(0,2);
				String dddt_day = value.substring(3,5);
				String dddt_year = value.substring(6,10);
				String dddt_hour = value.substring(11,13);
				String dddt_mins = value.substring(14,16);

				if(Integer.parseInt(dddt_month) > 12){
					errors.rejectValue("dueDttm","patient.duedttm.error.datemontherror");
				}
				if(Integer.parseInt(dddt_day) > 31){
					errors.rejectValue("dueDttm","patient.duedttm.error.datedayerror");
				}
				if(Integer.parseInt(dddt_hour) > 24){
					errors.rejectValue("dueDttm","patient.duedttm.error.datehourerror");
				}
				if(Integer.parseInt(dddt_mins) > 59){
					errors.rejectValue("dueDttm","patient.duedttm.error.dateminuteserror");
				}

				int dddtmonthcheck = Integer.parseInt(dddt_month);

				//30 day month check
				int[] thirtydaymonths = {4,6,9,11};
				for (int i=0; i < thirtydaymonths.length;i++){
					if (thirtydaymonths[i] == dddtmonthcheck){
						if(Integer.parseInt(dddt_day) > 30){
							errors.rejectValue("dueDttm","patient.duedttm.error.datedaysinvalid");
						}
					}
				}

				//Leap Year check
				if(dddtmonthcheck == 2){
					int dddtyearcheck = Integer.parseInt(dddt_year)-1900;
					if ((dddtyearcheck % 4 == 0) && (!(dddtyearcheck % 100 == 0)
						|| (dddtyearcheck % 400) == 0)){
							//then leapyear, should be 29days total
							if(Integer.parseInt(dddt_day) > 29){
								errors.rejectValue("dueDttm","patient.duedttm.error.datedaysinvalid_isleapyear");
							}
					}else{
						//should be 28days total
						if(Integer.parseInt(dddt_day) > 28){
							errors.rejectValue("dueDttm","patient.duedttm.error.datedaysinvalid_notleapyear");
						}
					}
				}

				java.util.Date dddt_date = new java.util.Date(Integer.parseInt(dddt_year)-1900, Integer.parseInt(dddt_month)-1,
				Integer.parseInt(dddt_day), Integer.parseInt(dddt_hour), Integer.parseInt(dddt_mins));

			  	//fourth, make sure entered date is after current date/time
			  	Date today = new Date();
			  	today.getTime();
			  	if(dddt_date.before(today)){
			  		errors.rejectValue("dueDttm","patient.duedttm.datebeforeerror");
			  	}
			 }
		 }		

		
		
	}
	
	
}
