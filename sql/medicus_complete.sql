create database medicus;
use medicus;

#select * from patient
#select * from patient_record
#select * from security_role
#select * from user_security_role

/* Main patient table */ 
CREATE TABLE `medicus`.`patient` (
  `patient_id` INT NOT NULL AUTO_INCREMENT,
  `name_prefix` VARCHAR(45) NULL,
  `name_first` VARCHAR(45) NOT NULL,
  `name_middle` VARCHAR(45) NULL,
  `name_last` VARCHAR(45) NOT NULL,
  `name_suffix` VARCHAR(45) NULL,
  `home_street_addr1` VARCHAR(200) NULL,
  `home_street_addr2` VARCHAR(200) NULL,
  `home_city` VARCHAR(45) NULL,
  `home_state` VARCHAR(45) NULL,
  `home_zipcode` VARCHAR(45) NULL,
  `work_street_addr1` VARCHAR(200) NULL,
  `work_street_addr2` VARCHAR(200) NULL,
  `work_city` VARCHAR(45) NULL,
  `work_state` VARCHAR(45) NULL,
  `work_zipcode` VARCHAR(45) NULL,  
  `country` VARCHAR(45) NULL,
  `ssn` VARCHAR(45) NULL,
  `acct_no` VARCHAR(45) NULL,
  `home_phone` VARCHAR(45) NULL,
  `work_phone` VARCHAR(45) NULL,
  `mobile_phone` VARCHAR(45) NULL,
  `emergency_contact` VARCHAR(50) NULL,
  `emergency_phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `date_birth` VARCHAR(45) NULL,
  `created_dttm` DATETIME NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE (patient_id)
 );
insert into patient (name_prefix, name_first, name_middle, name_last, home_street_addr1, home_street_addr2, home_city, home_state, home_zipcode, home_phone, work_phone, mobile_phone, email, created_dttm) 
values ("Mr","Bob","L","Smith","200 N. Blvd","Suite 100", "Tampa","FL","33605","813-333-HOME", "813-333-WORK","813-333-MOBL","bob.smith@what.com", now());
insert into patient (name_prefix, name_first, name_middle, name_last, home_street_addr1, home_street_addr2, home_city, home_state, home_zipcode, home_phone, work_phone, mobile_phone, email, created_dttm) 
values ("Mr","Donald","J","Duck","Disneyland Resort","PO Box 3232", "Anaheim","CA","92803-3232", "310-111-HOME","310-111-WORK","310-111-MOBL","donaldduck@disney.com", now());

/*
update patient set password='$2a$10$pPBPcwqNmGFgdr5gYhT6VeeVIiSwG2QKWO8eiTYlTCEPObkPUrHFy' where patient_id='3'
select * from patient
*/

/* patient allergies */
CREATE TABLE `medicus`.`patient_allergy` (
  `allergy_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,
  `name` VARCHAR(50) NULL,
  `description` VARCHAR(255) NULL,
  `danger_level` VARCHAR(50) NULL,
  `solution` VARCHAR(50) NULL,
  `created_dttm` DATETIME NULL,
  PRIMARY KEY (`allergy_id`),
  UNIQUE (allergy_id),
  CONSTRAINT FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
 );
 
 
/* patient appointments */
CREATE TABLE `medicus`.`patient_appt` (
  `appt_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,
  `physician_id` INT NULL,
  `description` VARCHAR(255) NULL,
  `appt_dttm` DATETIME NULL,
  `created_dttm` DATETIME NULL,
  PRIMARY KEY (`appt_id`),
  UNIQUE (appt_id),
  CONSTRAINT FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
 );


/* patient medications */
CREATE TABLE `medicus`.`patient_medication` (
  `presc_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,
  `physician_id` INT NULL,
  `name` VARCHAR(50) NULL,
  `description` VARCHAR(255) NULL,
  `dosage` VARCHAR(50) NULL,
  `interval` VARCHAR(50) NULL,
  `duration` VARCHAR(50) NULL,
  `start_dttm` DATETIME NULL,
  `end_dttm` DATETIME NULL,
  `created_dttm` DATETIME NULL,
  PRIMARY KEY (`presc_id`),
  UNIQUE (presc_id),
  CONSTRAINT FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
 );


/* patient procedures */
CREATE TABLE `medicus`.`patient_procedure` (
  `procedure_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,  
  `physician_id` INT NULL,
  `description` VARCHAR(255) NULL,
  `postproceduredetails` VARCHAR(255) NULL,
  `scheduled_dttm` DATETIME NULL,
  `completed_dttm` DATETIME NULL,
  `created_dttm` DATETIME NULL,
  PRIMARY KEY (`procedure_id`),
  UNIQUE (procedure_id),
  CONSTRAINT FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
 );
 
 
  /* list of insurance providers */
CREATE TABLE `medicus`.`provider` (
  `provider_id` INT NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address1` varchar(100) NULL,
  `address2` varchar(100) NULL,
  `city` varchar(100) NULL,
  `state` varchar(100) NULL,
  `zipcode` varchar(100) NULL,
  `phone_main` varchar(100) NULL,
  `phone_fax` varchar(100) NULL,
  `created_dttm` DATETIME NULL,
  `updated_dttm` DATETIME NULL,
  PRIMARY KEY (`provider_id`)
);
insert into medicus.provider (name,address1,address2,city,state,zipcode,phone_main,phone_fax, created_dttm) 
	values ("Aetna","151 Farmington Avenue","","Hartford","CT","06156","800-87-AETNA","800-87-AETNA", now());
insert into medicus.provider (name,address1,address2,city,state,zipcode,phone_main,phone_fax, created_dttm) 
	values ("United Healthcare","10151 Deerwood Park","Bldg 100, Ste 420","Jacksonville","FL","32256","800-250-6178","800-250-6178", now());
insert into medicus.provider (name,address1,address2,city,state,zipcode,phone_main,phone_fax, created_dttm) 
	values ("Humana","P.O. Box 14601","","Lexington","KY","40512–4601","800-833-6917","800-833-6917", now());
#select * from medicus.provider


/* link table provider insurance list to patients */
/* many to many */
CREATE TABLE `medicus`.`patient_provider` (
  `patient_id` INT NOT NULL,
  `provider_id` INT NOT NULL,
  PRIMARY KEY (`patient_id`,`provider_id`),
  KEY `fk_patient` (`patient_id`),
  KEY `fk_provider` (`provider_id`),
  CONSTRAINT `fk_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  CONSTRAINT `fk_provider` FOREIGN KEY (`provider_id`) REFERENCES `provider` (`provider_id`)
);
insert into patient_provider (patient_id,provider_id) values ("1","2");
insert into patient_provider (patient_id,provider_id) values ("2","1");


CREATE TABLE `medicus`.`physician` (
  `physician_id` INT NOT NULL AUTO_INCREMENT,
  `specialty` VARCHAR(45) NULL,
  `name_prefix` VARCHAR(45) NULL,
  `name_first` VARCHAR(45) NOT NULL,
  `name_middle` VARCHAR(45) NULL,
  `name_last` VARCHAR(45) NOT NULL,
  `street_addr1` VARCHAR(200) NULL,
  `street_addr2` VARCHAR(200) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `zipcode` VARCHAR(45) NULL,  
  `acct_no` VARCHAR(45) NULL,
  `office_phone` VARCHAR(45) NULL,
  `fax_phone` VARCHAR(45) NULL,  
  `mobile_phone` VARCHAR(45) NULL,  
  `email_physician` VARCHAR(45) NULL,
  `email_main` VARCHAR(45) NOT NULL,  
  `created_dttm` DATETIME NULL,
  PRIMARY KEY (`physician_id`),
  UNIQUE (physician_id)
 );
insert into physician (physician_id, specialty, name_prefix, name_first, name_last, street_addr1, street_addr2, city, state, zipcode, office_phone, email_main) 
	values ("1","Internal Medicine","Dr.","William","Who","76 Totter's Lane","Suite 900","Tampa","FL","33602","813-515-1212","drwho@tardis.com");
insert into physician (physician_id, specialty, name_prefix, name_first, name_last, street_addr1, street_addr2, city, state, zipcode, office_phone, email_main) 
	values ("2","Pediatrician","Dr.","Laura","Smith","1200 N. Blvd","Suite 101","Tampa","FL","33602","813-233-1000","laurasmith@someemail.com");



#--------[MEDICAL FORMS / RECORDS]--------------------------------------------------------

/*
1.	Add records list per patient in the patiend_records table (form_id links to form table)
	This is the list on the patient details page
2.	For each patient form table add record for a patient (links with form_id)

3.	When a patient clicks on a record, it uses the entity class and form_id to 
	retrieve the proper record from the proper form table
*/

/* MASTER TABLE for links used on Patient Details list of records */
/* links to patient records */
CREATE TABLE `medicus`.`patient_record` (
  `patient_record_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,
  `physician_id` INT NULL,
  `form_id` INT NOT NULL,
  `entity` VARCHAR(255) NULL,
  `form_display_name` VARCHAR(255) NULL,
  PRIMARY KEY (`patient_record_id`),
  CONSTRAINT FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
 );
# PRIMARY KEY (`form_id`),
# UNIQUE (form_id),
# drop table `medicus`.`patient_record`
# select * from `medicus`.`patient_record`
# truncate table patient_record

insert into patient_record (form_id, patient_id, physician_id, entity, form_display_name)
	values ("1","1","1","PatientRecordMedHist","Medical History");
insert into patient_record (form_id, patient_id, physician_id, entity, form_display_name)
	values ("2","2","1","PatientRecordMedHist","Medical History");

insert into patient_record (form_id, patient_id, physician_id, entity, form_display_name)
	values ("1","1","1","MedicalRecordAuthIn","Release of Medical Records");
insert into patient_record (form_id, patient_id, physician_id, entity, form_display_name)
	values ("2","2","1","MedicalRecordAuthIn","Release of Medical Records");

insert into patient_record (form_id, patient_id, physician_id, entity, form_display_name)
	values ("3","3","1","PatientRecordMedHist","Medical History");
insert into patient_record (form_id, patient_id, physician_id, entity, form_display_name)
	values ("4","3","1","PatientRecordLab","Lab Results");
insert into patient_record (form_id, patient_id, physician_id, entity, form_display_name)
	values ("5","3","1","PatientRecordMedRelIn","Medical Records Release Form: from Physicians");
insert into patient_record (form_id, patient_id, physician_id, entity, form_display_name)
	values ("6","3","1","PatientRecordMedRelOut","Medical Records Release Form: to Physicians");
#truncate table patient_record
#select * from rec_medhist
#select * from patient_record


/* patient record form for: medical history */
CREATE TABLE `medicus`.`rec_medhist` (
  `form_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,
  `physician_id` INT NULL,
  `created_dttm` DATETIME NULL,
  `gender` VARCHAR(45) NULL,
  `height_ft` VARCHAR(45) NULL,
  `height_in` VARCHAR(45) NULL,
  `weight` VARCHAR(45) NULL,
  `bmi` VARCHAR(45) NULL,
  `ethnicity` VARCHAR(45) NULL,
  PRIMARY KEY (`form_id`),
  UNIQUE (form_id),
  CONSTRAINT FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
 );
insert into rec_medhist (patient_id, physician_id, gender, height_ft, height_in, weight, bmi, created_dttm) 
	values ("1","1","M","6","2","195","25", now());
insert into rec_medhist (patient_id, physician_id, gender, height_ft, height_in, weight, bmi, created_dttm) 
	values ("2","1","M","5","5","120","25", now());
insert into rec_medhist (patient_id, physician_id, gender, height_ft, height_in, weight, bmi, created_dttm) 
	values ("3","1","M","6","2","195","25", now());


/* patient record form for: authorization of release of records FROM other doctors */ 
 CREATE TABLE `medicus`.`rec_auth_medrel_in` (
  `form_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,
  `physician_id` INT NULL,  
  `patient_permission` VARCHAR(45) NULL,
  `created_dttm` DATETIME NULL,
  PRIMARY KEY (`form_id`),
  UNIQUE (form_id),
  CONSTRAINT FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
 );
insert into rec_auth_medrel_in (patient_id, physician_id, patient_permission, created_dttm) 
	values ("1","1","Y",now());
insert into rec_auth_medrel_in (patient_id, physician_id, patient_permission, created_dttm) 
	values ("2","1","N",now());



#--------[LOGIN - USER AUTHENTICATION]--------------------------------------------------------

/*
CREATE TABLE `medicus`.`patients_sso` (
  `patient_id` INT NOT NULL AUTO_INCREMENT,
  `sso_id` INT NOT NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE (sso_id)
 );
 */


/* Stores all user roles USER_PROFILE */ 
create table SECURITY_ROLE(
   id INT NOT NULL AUTO_INCREMENT,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (type)
);
INSERT INTO SECURITY_ROLE(type) VALUES ('PATIENT');
INSERT INTO SECURITY_ROLE(type) VALUES ('PHYSICIAN');
INSERT INTO SECURITY_ROLE(type) VALUES ('ADMIN');
#select * from SECURITY_ROLE

/* For MANY-TO-MANY relationship - PATIENTS_USER_PROFILE */  
CREATE TABLE USER_SECURITY_ROLE (
    user_id INT NOT NULL,
    user_profile_id INT NOT NULL,
    PRIMARY KEY (user_id, user_profile_id),
    CONSTRAINT FK_PATIENT_ID FOREIGN KEY (user_id) REFERENCES PATIENT (patient_id), 
    CONSTRAINT FK_SECURITY_ROLE FOREIGN KEY (user_profile_id) REFERENCES SECURITY_ROLE (id)
);
INSERT INTO USER_SECURITY_ROLE (user_id, user_profile_id)
  SELECT user.patient_id, profile.id FROM patient user, SECURITY_ROLE profile
  where user.email='jason.muse@gmail.com' and profile.type='ADMIN';
INSERT INTO USER_SECURITY_ROLE (user_id, user_profile_id)
  SELECT user.patient_id, profile.id FROM patient user, SECURITY_ROLE profile
  where user.email='jason.muse@gmail.com' and profile.type='PATIENT';


/* Stores tokens for RememberMe logins */
CREATE TABLE USER_SESSIONS (
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_login TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
);

#select * from user_sessions
#select * from patient
#select * from patient_record
#select * from security_role
#select * from user_security_role

