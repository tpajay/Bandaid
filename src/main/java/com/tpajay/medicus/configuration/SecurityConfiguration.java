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

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
	//customer class that implements Spring Core UserDetailsService
    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;
 
    @Autowired
    PersistentTokenRepository tokenRepository;
    
    @Autowired
    public void configureMedicusSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }
 
    /* 
     * loginPage("/login"): when authentication is required, redirect the browser to /login
     * formLogin().loginPage("/login"):	we are in charge of rendering the login page when /login is requested
     */
    /*
     * FROM SPRING SITE:
     * loginPage("/login"):
     * when authentication is required, redirect the browser to /login
     * 
     * formLogin().loginPage("/login"):
     * The line loginPage("/login") instructs Spring Security
     * -when authentication is required, redirect the browser to /login
     * -we are in charge of rendering the login page when /login is requested
     * -when authentication attempt fails, redirect the browser to /login?error (since we have not specified otherwise)
     * -we are in charge of rendering a failure page when /login?error is requested
     * -when we successfully logout, redirect the browser to /login?logout (since we have not specified otherwise)
     * -we are in charge of rendering a logout confirmation page when /login?logout is requested
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
