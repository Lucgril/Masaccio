/*All User's are stored in APP_USER table*/
create table APP_USER (
   id BIGINT NOT NULL AUTO_INCREMENT,
   sso_id VARCHAR(30) NOT NULL,
   password VARCHAR(100) NOT NULL,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   email VARCHAR(30) NOT NULL,
   state VARCHAR(30) NOT NULL, 	
   PRIMARY KEY (id),
   UNIQUE (sso_id)
);
 
/* USER_PROFILE table contains all possible roles */
create table USER_PROFILE(
   id BIGINT NOT NULL AUTO_INCREMENT,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (type)
);
 
/* JOIN TABLE for MANY-TO-MANY relationship*/ 
CREATE TABLE APP_USER_USER_PROFILE (
    user_id BIGINT NOT NULL,
    user_profile_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, user_profile_id),
    CONSTRAINT FK_APP_USER FOREIGN KEY (user_id) REFERENCES APP_USER (id),
    CONSTRAINT FK_USER_PROFILE FOREIGN KEY (user_profile_id) REFERENCES USER_PROFILE (id)
);

* Populate USER_PROFILE Table */
INSERT INTO USER_PROFILE(type)
VALUES ('USER');
 
INSERT INTO USER_PROFILE(type)
VALUES ('ADMIN');
 
INSERT INTO USER_PROFILE(type)
VALUES (‘EMPLOYEE’);

INSERT INTO USER_PROFILE(type)
VALUES (‘RESPONDER’);
 
/* Populate APP_USER Table */
INSERT INTO APP_USER(sso_id, password, first_name, last_name, email, state)
VALUES (‘admin’,’admin’, ‘Luca’,’Grillo’,’bill@xyz.com', 'Active');
 
INSERT INTO APP_USER(sso_id, password, first_name, last_name, email, state)
VALUES (‘user’,’user’, 'Danny','Theys','danny@xyz.com', 'Active');
 
INSERT INTO APP_USER(sso_id, password, first_name, last_name, email, state)
VALUES (‘employee’,’employee’, 'Sam','Smith','samy@xyz.com', 'Active');
 
INSERT INTO APP_USER(sso_id, password, first_name, last_name, email, state)
VALUES (‘responder’,’responder’, 'Nicole','warner','nicloe@xyz.com', 'Active');
 
/* Populate JOIN Table */
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user user, user_profile profile  
  where user.sso_id=‘admin’ and profile.type=‘ADMIN’;
 
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user user, user_profile profile
  where user.sso_id=‘user’ and profile.type='USER';
 
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user user, user_profile profile
  where user.sso_id=‘employee’ and profile.type=‘EMPLOYEE’;
 
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user user, user_profile profile
  where user.sso_id=‘responder’ and profile.type=‘RESPONDER’;
