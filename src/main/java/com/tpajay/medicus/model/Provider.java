package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROVIDER")
public class Provider {

	@Id
	@GeneratedValue
	@Column(name="PROVIDER_ID")
	private int providerId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address1")
	private String addr1;
	
	@Column(name="address2")
	private String addr2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zipcode")
	private String zipcode;
	
	@Column(name="phone_main")
	private String phoneMain;
	
	@Column(name="phone_fax")
	private String phoneFax;
	
	@Column(name="created_dttm")
	private String createdDttm;
	
	@Column(name="updated_dttm")
	private String updatedDttm;
	
}
