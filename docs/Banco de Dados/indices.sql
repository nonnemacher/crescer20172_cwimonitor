CREATE INDEX INFO_TIME_MACHINE
   ON MACHINE_INFO (EXEC_TIME, ID_MACHINE_REGISTER);
   
  
CREATE INDEX INFO_MACHINE
   ON MACHINE_INFO (ID_MACHINE_REGISTER);   

CREATE INDEX INFO_TIME
   ON MACHINE_INFO (EXEC_TIME);

CREATE INDEX ALERT_MACHINE
   ON ALERT (ID_MACHINE_REGISTER);
   
CREATE INDEX ALERT_GROUP
   ON ALERT (ID_GROUP_REGISTER);
   

CREATE INDEX MACHINE_GROUP
   ON MACHINE_MONITORING_REGISTER (FK_MONITORING,FK_REGISTER);

CREATE INDEX MACHINE_REGISTER
   ON MACHINE_REGISTER (ID_COLLABORATOR);
   
CREATE INDEX TAG
   ON MACHINE_TAG_REGISTER (FK_TAG,FK_REGISTER); 
   
