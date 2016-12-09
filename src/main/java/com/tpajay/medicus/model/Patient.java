package com.tpajay.medicus.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tpajay.medicus.security.model.SecurityRole;

@Entity
@Table(name="PATIENT")
public class Patient {

	@Id
	@GeneratedValue
	@Column(name="PATIENT_ID")
	private int patientId;
	
	//eager: load all patient records for view
	@JsonIgnore //ignore for json rest responses, prevent infinite recursive list back to interface
	@OneToMany(targetEntity=PatientRecord.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	@JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
	//@OrderBy("")
    private Set<PatientRecord> records;
	
	//lazy: load user security roles when getSecurityRoles() is called
	@JsonIgnore //ignore for json rest responses
    //@NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_SECURITY_ROLE", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
    private Set<SecurityRole> securityRoles = new HashSet<SecurityRole>();
    
	//Just using this to test date validations using the PatientValidator class
	//Not stored in the database, just for testing
	@Transient
	private String dueDttm;
	
	@Column(name="name_prefix")
	private String namePrefix;
	
	//@NotNull
	@Column(name="name_first")
	private String nameFirst;
	
	@Column(name="name_middle")
	private String nameMiddle;
	
	//@NotNull
	@Column(name="name_last")
	private String nameLast;
	
	@Column(name="name_suffix")
	private String nameSuffix;
	
	@Column(name="home_street_addr1")
	private String homeStreetAddr1;
	
	@Column(name="home_street_addr2")
	private String homeStreetAddr2;
	
	@Column(name="home_city")
	private String homeCity;
	
	@Column(name="home_state")
	private String homeState;
	
	@Column(name="home_zipcode")
	private String homeZipcode;
	
	@Column(name="work_street_addr1")
	private String workStreetAddr1;
	
	@Column(name="work_street_addr2")
	private String workStreetAddr2;
	
	@Column(name="work_city")
	private String workCity;
	
	@Column(name="work_state")
	private String workState;
	
	@Column(name="work_zipcode")
	private String workZipcode;
	
	@Column(name="country")
	private String country;
	
	//last 4-digits only
	@Column(name="ssn")
	private String ssn;
	
	//need to move this to account number per physician
	@Column(name="acct_no")
	private String acctNo;
	
	@Column(name="home_phone")
	private String phoneHome;
	
	@Column(name="work_phone")
	private String phoneWork;
	
	@Column(name="mobile_phone")
	private String phoneMobile;
	
	@Column(name="emergency_contact")
	private String emergencyContact;
	
	@Column(name="emergency_phone")
	private String emergencyPhone;
	
	//@NotNull @Email
	@Column(name="email")
	private String email;
	
	@Transient
	private String emailVerify;
	
	//@DateTimeFormat(pattern="MM/dd/yyyy")
    //@NotNull @Past
    //private Date dob;
	@Column(name="date_birth")
	private String dob;
	
	@Column(name="created_dttm")
	private String createdDttm;

	@Column(name="password")
	private String password;
	
	@Transient
	private String passwordVerify;	
	
	
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public Set<PatientRecord> getRecords() {
		return records;
	}

	public void setRecords(Set records) {
		this.records = records;
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

	public String getNameSuffix() {
		return nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public String getHomeStreetAddr1() {
		return homeStreetAddr1;
	}

	public void setHomeStreetAddr1(String homeStreetAddr1) {
		this.homeStreetAddr1 = homeStreetAddr1;
	}

	public String getHomeStreetAddr2() {
		return homeStreetAddr2;
	}

	public void setHomeStreetAddr2(String homeStreetAddr2) {
		this.homeStreetAddr2 = homeStreetAddr2;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getHomeState() {
		return homeState;
	}

	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}

	public String getHomeZipcode() {
		return homeZipcode;
	}

	public void setHomeZipcode(String homeZipcode) {
		this.homeZipcode = homeZipcode;
	}

	public String getWorkStreetAddr1() {
		return workStreetAddr1;
	}

	public void setWorkStreetAddr1(String workStreetAddr1) {
		this.workStreetAddr1 = workStreetAddr1;
	}

	public String getWorkStreetAddr2() {
		return workStreetAddr2;
	}

	public void setWorkStreetAddr2(String workStreetAddr2) {
		this.workStreetAddr2 = workStreetAddr2;
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public String getWorkZipcode() {
		return workZipcode;
	}

	public void setWorkZipcode(String workZipcode) {
		this.workZipcode = workZipcode;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getPhoneHome() {
		return phoneHome;
	}

	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}

	public String getPhoneWork() {
		return phoneWork;
	}

	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}

	public String getPhoneMobile() {
		return phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getEmergencyPhone() {
		return emergencyPhone;
	}

	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCreatedDttm() {
		return createdDttm;
	}

	public void setCreatedDttm(String createdDttm) {
		this.createdDttm = createdDttm;
	}

	public String getDueDttm() {
		return dueDttm;
	}

	public void setDueDttm(String dueDttm) {
		this.dueDttm = dueDttm;
	}

	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getEmailVerify() {
		return emailVerify;
	}

	public void setEmailVerify(String emailVerify) {
		this.emailVerify = emailVerify;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordVerify() {
		return passwordVerify;
	}

	public void setPasswordVerify(String passwordVerify) {
		this.passwordVerify = passwordVerify;
	}

	public Set<SecurityRole> getSecurityRoles() {
		return securityRoles;
	}

	public void setSecurityRoles(Set<SecurityRole> securityRoles) {
		this.securityRoles = securityRoles;
	}

	
}
