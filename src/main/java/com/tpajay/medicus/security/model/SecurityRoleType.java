package com.tpajay.medicus.security.model;

import java.io.Serializable;

public enum SecurityRoleType implements Serializable{
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");
     
    String userProfileType;
     
    private SecurityRoleType(String userProfileType){
        this.userProfileType = userProfileType;
    }
     
    public String getUserProfileType(){
        return userProfileType;
    }
     
}
