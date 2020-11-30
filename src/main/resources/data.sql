DROP TABLE IF EXISTS Offices;

create table Offices (
  OfficesID INT AUTO_INCREMENT  PRIMARY KEY,
  ID varchar(250),
  Name varchar(250),
  Location varchar(250),
  Email varchar(250),
  tell_number varchar(100),
  max_occupants int,
  Color varchar(100) default 'Black'
);

INSERT INTO Offices(ID, Name, Location, Email, tell_number, max_occupants, Color) VALUES(
  'SKJNCKJSNDCKJSACSALKDJC', 
  'Specno', 
  '1st Floor, Newlink Building, 1 new street, Cape Town, South Africa', 
  'dev@specno.com', 
  '0872320000',
  23, 
  'LightBlue'
),
(
  'SJDCAKJSDCJASNSDKCNSANCKS', 
  'Another Office', 
  'A different location', 
  'dev@office.com', 
  '0923209302',
  23, 
  'LightBlue'
);



DROP TABLE IF EXISTS Staff;


create table Staff (
  staffID INT AUTO_INCREMENT  PRIMARY KEY,
  ID varchar(250) NOT Null,
  OfficeID varchar(250) NOT NULL, 
  full_name varchar(250) NOT NULL
);

--ALTER table Staff 
--ADD FOREIGN KEY (OfficeID) 
--REFERENCES Offices(ID);

INSERT INTO Staff(ID, OfficeID, full_name) VALUES(
  'ASKDCASJKNCKALJSNCA',
  'SKJNCKJSNDCKJSACSALKDJC',
  'Test Employee'
),
(
  'KLSJDNCASJNDCKJSDC',
  'SKJNCKJSNDCKJSACSALKDJC',
  'Test Employee Two'
),
(
  'SAKDJCNAKSJDNCJKSDC',
  'SJDCAKJSDCJASNSDKCNSANCKS',
  'Not with specno'
);

