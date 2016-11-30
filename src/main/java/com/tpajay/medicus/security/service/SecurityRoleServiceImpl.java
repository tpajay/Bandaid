package com.tpajay.medicus.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.tpajay.medicus.security.dao.SecurityRoleDao;
import com.tpajay.medicus.security.model.SecurityRole;
 
 
@Service("securityRoleService")
@Transactional
public class SecurityRoleServiceImpl implements SecurityRoleService{
     
    @Autowired
    SecurityRoleDao dao;
     
    public SecurityRole findById(int id) {
        return dao.findById(id);
    }
 
    public SecurityRole findByType(String type){
        return dao.findByType(type);
    }
 
    public List<SecurityRole> findAll() {
        return dao.findAll();
    }
}
