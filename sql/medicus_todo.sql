
#-----------------[TO BE COMPLETED]----------------------------------------------------
 /* patient record form for: authorization of release of records TO other doctors */ 
 CREATE TABLE `medicus`.`rec_auth_medrel_out` (
  `form_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,
  `physician_id` INT NULL,
  `created_dttm` DATETIME NULL,
  `form fields signatures` VARCHAR(45) NULL,
  PRIMARY KEY (`form_id`),
  UNIQUE (form_id),
  CONSTRAINT FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`)
 );


/* patient/doctor communications-correspondence */
CREATE TABLE `medicus`.`patient_correspondence` (
  `corr_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,  
  `physician_id` INT NULL,
  `message_text` VARCHAR(255) NULL,
  `sent_dttm` DATETIME NULL,
  `mark_read` VARCHAR(50) NULL,
  `created_dttm` DATETIME NULL,
  PRIMARY KEY (`corr_id`),
  UNIQUE (corr_id),
  CONSTRAINT FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
 );


/* patient/doctor billing */
/* eventually should provide link to billing table */
CREATE TABLE `medicus`.`patient_billing` (
  `billing_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,  
  `physician_id` INT NULL,
  `description` VARCHAR(255) NULL,
  `created_dttm` DATETIME NULL,
  `completed_dttm` DATETIME NULL,
  `created_dttm` DATETIME NULL,
  PRIMARY KEY (`procedure_id`),
  UNIQUE (procedure_id),
  CONSTRAINT FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
 );




