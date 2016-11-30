package com.tpajay.medicus.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


/*
 * Security configuration.  protects application URLs, validates submitted username/password, redirects to login form
 * Accessible to everyone:		/ & /list
 * Accessible only to Admin:	/newuser & /delete-user-*
 * Accessible to Admin & DBA:	/edit-user-*
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;
 
    @Autowired
    PersistentTokenRepository tokenRepository;
    
    
    /* Allows for easily building in memory authentication, LDAP authentication, 
     * JDBC based authentication, adding UserDetailsService, and adding AuthenticationProvider's.
     */
    @Autowired
    public void configureMedicusSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }
 
    /* 
     * loginPage("/login"): 			when authentication is required, redirect the browser to /login
     * formLogin().loginPage("/login"):	we are in charge of rendering the login page when /login is requested
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		.antMatchers("/", "/patientdetails").access("hasRole('PATIENT')")
                .antMatchers("/patientlist", "/deletePatient").access("hasRole('ADMIN')")
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/login").usernameParameter("loginId").passwordParameter("password")
                .and()
                .rememberMe().rememberMeParameter("remember-me")
                .tokenRepository(tokenRepository).tokenValiditySeconds(86400)
                .and()
                .csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
 
    @Bean
    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
        PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
                "remember-me", userDetailsService, tokenRepository);
        return tokenBasedservice;
    }
 
    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
        return new AuthenticationTrustResolverImpl();
    }
 
} //end class
