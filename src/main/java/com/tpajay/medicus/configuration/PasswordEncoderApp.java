package com.tpajay.medicus.configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderApp {

    public static void main(String[] args) {
    	
    	//used to encode a password for storage
    	String password = "password";
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	System.out.println(passwordEncoder.encode(password));
            
    }
 
}
