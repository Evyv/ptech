  CREATE TABLE SZERZODES
   (	
   AZON NUMBER, 
	KEZDODATUM TIMESTAMP (6), 
	VEGDATUM TIMESTAMP (6), 
	UGYFELAZON VARCHAR2(255 BYTE) NOT NULL ENABLE, 
	TERULET NUMBER DEFAULT 0, 
	AR NUMBER DEFAULT 0
   ) 
 