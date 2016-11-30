INSERT INTO USER_PROFILE(type) VALUES ('USER');
INSERT INTO USER_PROFILE(type) VALUES ('ADMIN');
INSERT INTO USER_PROFILE(type) VALUES ('DBA');

INSERT INTO PATIENTS(sso_id, password, bill_first_name, bill_last_name, email)
VALUES ('jason.muse@gmail.com','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Jason','Muse','jason.muse@gmail.com');

INSERT INTO PATIENTS_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM patients user, user_profile profile
  where user.sso_id='jason.muse@gmail.com' and profile.type='ADMIN';
  
select * from patients
select * from patients_user_profile

