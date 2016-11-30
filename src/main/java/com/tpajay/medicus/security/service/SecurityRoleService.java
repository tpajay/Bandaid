package com.tpajay.medicus.security.service;

import java.util.List;

import com.tpajay.medicus.security.model.SecurityRole;
 
 
public interface SecurityRoleService {
 
    SecurityRole findById(int id);
 
    SecurityRole findByType(String type);
     
    List<SecurityRole> findAll();
     
}
