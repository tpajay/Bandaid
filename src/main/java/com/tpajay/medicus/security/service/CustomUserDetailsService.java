package com.tpajay.medicus.security.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tpajay.medicus.dao.PatientDaoInterface;
import com.tpajay.medicus.model.Patient;
import com.tpajay.medicus.security.model.SecurityRole;
 
/*
 * UserDetailsService interface:
 * Core interface which loads user-specific data. It is used throughout the 
 * framework as a user DAO and is the strategy used by the DaoAuthenticationProvider.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
 
    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
     
    @Autowired
    private PatientDaoInterface patientHibernateDao;
    
    //Load Patient Details from DB using login id(email address)
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
    	Patient patient = patientHibernateDao.findByLoginId(loginId);
        logger.info("Patient : {}", patient);
        if(patient==null){
            logger.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(patient.getEmail(), patient.getPassword(), 
                 true, true, true, true, getGrantedAuthorities(patient));
    }
 
    //When loading patient Hibernate also loads the patients security roles
    //@JoinTable(name = "USER_SECURITY_ROLE",
    private List<GrantedAuthority> getGrantedAuthorities(Patient patient) {
    	
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();         
        for(SecurityRole securityRole : patient.getSecurityRoles()) {
        	logger.info("Security Role : {}", securityRole);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + securityRole.getType()));
        }
        logger.info("authorities : {}", authorities);
        return authorities;
    }
     
}
