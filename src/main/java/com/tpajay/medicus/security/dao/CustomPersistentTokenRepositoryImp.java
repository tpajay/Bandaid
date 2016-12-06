package com.tpajay.medicus.security.dao;

import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tpajay.medicus.security.model.UserSession;


//Customer implementation of PersistentTokenRepository
//capable of providing a remember-me service
//The abstraction used by PersistentTokenBasedRememberMeServices 
//to store the persistent login tokens for a user.
@Repository("customTokenRepositoryDao")
@Transactional
public class CustomPersistentTokenRepositoryImp implements PersistentTokenRepository {
 
    static final Logger logger = LoggerFactory.getLogger(CustomPersistentTokenRepositoryImp.class);
    
	@Autowired
	SessionFactory sessionFactory;
 
	//create new token, store in USER_SESSIONS table
    public void createNewToken(PersistentRememberMeToken token) {
    	logger.info("In CustomPersistentTokenRepositoryImp, createNewToken(): " + token.getTokenValue());
        UserSession userSession = new UserSession();
        userSession.setUsername(token.getUsername());
        userSession.setSeries(token.getSeries());
        userSession.setToken(token.getTokenValue());
        userSession.setLast_login(token.getDate());
        sessionFactory.getCurrentSession().save(userSession);
    }
 
    //retrieve token from USER_SESSIONS table for user
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
    	logger.info("In CustomPersistentTokenRepositoryImp, getTokenForSeries(): " + seriesId);
        try {
            Criteria crit = sessionFactory.getCurrentSession().createCriteria(UserSession.class);
            crit.add(Restrictions.eq("series", seriesId));
            UserSession userSession = (UserSession) crit.uniqueResult();
 
            return new PersistentRememberMeToken(userSession.getUsername(), userSession.getSeries(),
            		userSession.getToken(), userSession.getLast_login());
            
        } catch (Exception e) {
            logger.info("Token not found...");
            return null;
        }
    }
 
    //delete a token from the USER_SESSIONS table for a user
    public void removeUserTokens(String username) {
        logger.info("In CustomPersistentTokenRepositoryImp, removeUserTokens(): " + username);
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(UserSession.class);
        crit.add(Restrictions.eq("username", username));
        UserSession userSession = (UserSession) crit.uniqueResult();
        if (userSession != null) {
            logger.info("rememberMe was selected");
            sessionFactory.getCurrentSession().delete(userSession);
        }
 
    }
 
    //update token in the USER_SESSIONS for a user
    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        logger.info("In CustomPersistentTokenRepositoryImp, updateToken(): " + seriesId);
        UserSession userSession = (UserSession)sessionFactory.getCurrentSession().get(UserSession.class, seriesId);
        userSession.setToken(tokenValue);
        userSession.setLast_login(lastUsed);
        sessionFactory.getCurrentSession().update(userSession);
    }
 
}

