package com.tpajay.medicus.security.model;

import java.io.Serializable;

public enum RoleType implements Serializable {
	
    PATIENT("PATIENT"),
    PHYSICIAN("PHYSICIAN"),
    ADMIN("ADMIN");
     
    String userRole;
     
    private RoleType(String userRole) {
        this.userRole = userRole;
    }
     
    public String getUserRole() {
        return userRole;
    }
     
}
