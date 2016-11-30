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

/*
 * Implementation of PersistentTokenRepository to use Hibernate for tokens
 */
@Repository("customTokenRepositoryDao")
@Transactional
public class CustomTokenRepositoryImp implements PersistentTokenRepository {
 
    static final Logger logger = LoggerFactory.getLogger(CustomTokenRepositoryImp.class);
    
	@Autowired
	SessionFactory sessionFactory;
 
    public void createNewToken(PersistentRememberMeToken token) {
    	logger.info("In CustomeTokenRepository, createNewToken(): " + token.getTokenValue());
        UserSession userSession = new UserSession();
        userSession.setUsername(token.getUsername());
        userSession.setSeries(token.getSeries());
        userSession.setToken(token.getTokenValue());
        userSession.setLast_login(token.getDate());
        sessionFactory.getCurrentSession().save(userSession);
    }
 
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
    	logger.info("In CustomeTokenRepository, getTokenForSeries(): " + seriesId);
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
 
    public void removeUserTokens(String username) {
        logger.info("In CustomeTokenRepository, removeUserTokens(): " + username);
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(UserSession.class);
        crit.add(Restrictions.eq("username", username));
        UserSession userSession = (UserSession) crit.uniqueResult();
        if (userSession != null) {
            logger.info("rememberMe was selected");
            sessionFactory.getCurrentSession().delete(userSession);
        }
 
    }
 
    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        logger.info("In CustomeTokenRepository, updateToken(): " + seriesId);
        UserSession userSession = (UserSession)sessionFactory.getCurrentSession().get(UserSession.class, seriesId);
        userSession.setToken(tokenValue);
        userSession.setLast_login(lastUsed);
        sessionFactory.getCurrentSession().update(userSession);
    }
 
}

