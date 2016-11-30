package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PHYSICIAN")
public class Physician {

	@Id
	@GeneratedValue
	@Column(name="PHYSICIAN_ID")
	private int physicianId;
	
	@Column(name="specialty")
	private String specialty;
	
	@Column(name="name_prefix")
	private String namePrefix;
	
	@Column(name="name_first")
	private String nameFirst;
	
	@Column(name="name_middle")
	private String nameMiddle;
	
	@Column(name="name_last")
	private String nameLast;
	
	@Column(name="street_addr1")
	private String streetAddr1;
	
	@Column(name="street_addr2")
	private String streetAddr2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zipcode")
	private String zipcode;
	
	@Column(name="acct_no")
	private String acctNo;
	
	@Column(name="office_phone")
	private String phoneOffice;
	
	@Column(name="fax_phone")
	private String phoneFax;
	
	@Column(name="mobile_phone")
	private String phoneMobile;
	
	@Column(name="email_physician")
	private String email;
	
	@Column(name="email_main")
	private String emailMain;
	
	@Column(name="created_dttm")
	private String createdDttm;
	
}
