package com.tpajay.medicus.security.dao;

import java.util.List;

import com.tpajay.medicus.security.model.SecurityRole;
 
 
public interface SecurityRoleDao {
 
    List<SecurityRole> findAll();
     
    SecurityRole findByType(String type);
     
    SecurityRole findById(int id);
}
