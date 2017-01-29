package com.tpajay.medicus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* Physicians
* 
* @author  Jason Muse
* LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
* GitHub: https://github.com/tpajay
*/
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

	public int getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(int physicianId) {
		this.physicianId = physicianId;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getNamePrefix() {
		return namePrefix;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	public String getNameFirst() {
		return nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameMiddle() {
		return nameMiddle;
	}

	public void setNameMiddle(String nameMiddle) {
		this.nameMiddle = nameMiddle;
	}

	public String getNameLast() {
		return nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getStreetAddr1() {
		return streetAddr1;
	}

	public void setStreetAddr1(String streetAddr1) {
		this.streetAddr1 = streetAddr1;
	}

	public String getStreetAddr2() {
		return streetAddr2;
	}

	public void setStreetAddr2(String streetAddr2) {
		this.streetAddr2 = streetAddr2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getPhoneOffice() {
		return phoneOffice;
	}

	public void setPhoneOffice(String phoneOffice) {
		this.phoneOffice = phoneOffice;
	}

	public String getPhoneFax() {
		return phoneFax;
	}

	public void setPhoneFax(String phoneFax) {
		this.phoneFax = phoneFax;
	}

	public String getPhoneMobile() {
		return phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailMain() {
		return emailMain;
	}

	public void setEmailMain(String emailMain) {
		this.emailMain = emailMain;
	}

	public String getCreatedDttm() {
		return createdDttm;
	}

	public void setCreatedDttm(String createdDttm) {
		this.createdDttm = createdDttm;
	}
	
	
}
