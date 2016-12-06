package com.tpajay.medicus.security.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tpajay.medicus.security.model.SecurityRole;
 
  
@Repository("securityRoleDao")
public class SecurityRoleDaoImpl implements SecurityRoleDao {
	
    static final Logger logger = LoggerFactory.getLogger(CustomPersistentTokenRepositoryImp.class);
    
	@Autowired
	SessionFactory sessionFactory;
 
    public SecurityRole findById(int id) {
    	SecurityRole role = (SecurityRole)sessionFactory.getCurrentSession().get(SecurityRole.class, id);
		return role;
    }
 
    public SecurityRole findByType(String type) {
    	Criteria crit = sessionFactory.getCurrentSession().createCriteria(SecurityRole.class);
        crit.add(Restrictions.eq("type", type));
        return (SecurityRole) crit.uniqueResult();
    }
     
    @SuppressWarnings("unchecked")
    public List<SecurityRole> findAll(){
    	Criteria crit = sessionFactory.getCurrentSession().createCriteria(SecurityRole.class);
        crit.addOrder(Order.asc("type"));
        return (List<SecurityRole>)crit.list();
    }
     
}
