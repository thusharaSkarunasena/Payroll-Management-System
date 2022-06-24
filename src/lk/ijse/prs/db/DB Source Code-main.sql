
\q
cls
mysql -h localhost -u root -p1997

#<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Start >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

#*******************************************************************************

DROP DATABASE IF EXISTS PRSystem;
CREATE DATABASE PRSystem;
USE PRSystem;

#*******************************************************************************

DROP TABLE IF EXISTS allowance;
CREATE TABLE allowance(
	allowanceID VARCHAR(30),
	description VARCHAR(300),
	amount DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(allowanceID)
);

INSERT INTO allowance VALUES
	("AL001","As foodAL=5000.00, transportAL=2000.00 & accommodationAL=5000.00",12000.00),
	("AL002","As foodAL=5000.00, transportAL=2000.00 & accommodationAL=4000.00",11000.00),
	("AL003","As foodAL=4000.00, transportAL=2000.00 & accommodationAL=4000.00",10000.00),
	("AL004","As foodAL=4000.00, transportAL=1500.00 & accommodationAL=3000.00",8500.00),
	("AL005","As foodAL=3500.00, transportAL=1500.00 & accommodationAL=2000.00",7000.00),
	("AL006","As foodAL=3000.00, transportAL=1500.00 & accommodationAL=2000.00",6500.00);


#*******************************************************************************

DROP TABLE IF EXISTS employeeType;
CREATE TABLE employeeType(
	employeeTypeID VARCHAR(30),
	allowanceID VARCHAR(30),
	name VARCHAR(60),
	description VARCHAR(300),
	basicSalary DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeTypeID),
	CONSTRAINT FOREIGN KEY(allowanceID) REFERENCES allowance(allowanceID)
);

INSERT INTO employeeType VALUES
	("ET0001","AL001","Manager","This is the Manager with AllowanceID AL001",56000.00),
	("ET0002","AL002","Assistan Manager","This is the Assistance manager with AllowanceID AL002",40000.00),
	("ET0003","AL003","Supervisor","This is the Supervisor with AllowanceID AL003",36000.00),
	("ET0004","AL003","Assistan Supervisor","This is the Assistance Supervisor with AllowanceID AL003",30000.00),
	("ET0005","AL004","Clark","This is the Clark with AllowanceID AL004",25000.00),
	("ET0006","AL005","Labor","This is the Labor with AllowanceID AL005",20000.00);

#*******************************************************************************
DROP TABLE IF EXISTS employee;
CREATE TABLE employee(
	employeeID VARCHAR(30),
	employeeTypeID VARCHAR(30),
	name VARCHAR(60),
	nic VARCHAR(15),
	address_no VARCHAR(30),
	address_street VARCHAR(30),
	address_village VARCHAR(30),
	address_city VARCHAR(30),
	contactNo_home VARCHAR(15),
	contactNo_mobile VARCHAR(15),
	other_detail VARCHAR(60),
	CONSTRAINT PRIMARY KEY(employeeID),
	CONSTRAINT FOREIGN KEY(employeeTypeID) REFERENCES employeeType(employeeTypeID)
);

INSERT INTO employee VALUES
	("E0001","ET0001","Mr.Kasun","759687452V","56","Salmal Road","Wawala","Nagoda","0342256751","0718936478","otherDetails_Kasun"),
	("E0002","ET0005","Mr.Piyal","812345796V","23/4","Second Lane","Seelama","Beruwala","0345689712","0775698312","otherDetails_Piyal"),
	("E0003","ET0006","Mrs.Ruvini","925678412V","12/A","Barton Place","Pinwatta","Panadura","0382246912","0719863145","otherDetails_Ruvini"),
	("E0004","ET0002","Mrs.Nadeeka","869574125V","246","Sirimewan Road","Villegoda","Dodangoda","0345896712","0759687468","otherDetails_Nadeeka"),
	("E0005","ET0006","Mr.Madawa","895674125V","88/3","Samagi Road","Panapitiya","Horana","0342296872","0714589687","otherDetails_Madawa");

#*******************************************************************************
DROP TABLE IF EXISTS attendance;
CREATE TABLE attendance(
	employeeID VARCHAR(30),
	curDate DATE,
	inTime TIME,
	outTime TIME,
	CONSTRAINT PRIMARY KEY(employeeID, curDate)
);

#*******************************************************************************
DROP TABLE IF EXISTS empLeave;
CREATE TABLE empLeave(
	employeeID VARCHAR(30),
	curDate DATE,
	leaveType VARCHAR(30),
	inTime TIME,
	outTime TIME,
	CONSTRAINT PRIMARY KEY(employeeID, curDate)
);

#*******************************************************************************

DROP TABLE IF EXISTS holiday;
CREATE TABLE holiday(
	employeeID VARCHAR(30),
	curDate DATE,
	holidayType VARCHAR(30),
	description VARCHAR(300),
	CONSTRAINT PRIMARY KEY(employeeID, curDate)
);

#*******************************************************************************

DROP TABLE IF EXISTS OT_DOT_Rate;
CREATE TABLE OT_DOT_Rate(
	OT_DOT_RateID VARCHAR(30),
	employeeTypeID VARCHAR(30),
	OTRate DOUBLE(10,2),
	DOTRate DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(OT_DOT_RateID),
	CONSTRAINT FOREIGN KEY(employeeTypeID) REFERENCES employeeType(employeeTypeID)
);

INSERT INTO OT_DOT_Rate VALUES
	("ODR01","ET0001",300.00,500.00),
	("ODR02","ET0002",250.00,400.00),
	("ODR03","ET0003",200.00,350.00),
	("ODR04","ET0004",150.00,300.00),
	("ODR05","ET0005",120.00,250.00),
	("ODR06","ET0006",90.00,180.00);

#*******************************************************************************

DROP TABLE IF EXISTS OT;
CREATE TABLE OT(
	employeeID VARCHAR(30),
	curDate DATE,
	OT_DOT_RateID VARCHAR(30),
	OTAmount DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeID, curDate),
	CONSTRAINT FOREIGN KEY(OT_DOT_RateID) REFERENCES OT_DOT_Rate(OT_DOT_RateID)
);

#*******************************************************************************

DROP TABLE IF EXISTS DOT;
CREATE TABLE DOT(
	employeeID VARCHAR(30),
	curDate DATE,
	OT_DOT_RateID VARCHAR(30),
	DOTAmount DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeID, curDate),
	CONSTRAINT FOREIGN KEY(OT_DOT_RateID) REFERENCES OT_DOT_Rate(OT_DOT_RateID)
);

#*******************************************************************************

DROP TABLE IF EXISTS NoPay;
CREATE TABLE NoPay(
	employeeID VARCHAR(30),
	curDate DATE,
	NoPayAmount DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeID, curDate)
);

#*******************************************************************************

DROP TABLE IF EXISTS lateComing;
CREATE TABLE lateComing(
	employeeID VARCHAR(30),
	curDate DATE,
	inTime TIME,
	lateComingAmount DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeID, curDate)
);

#*******************************************************************************

DROP TABLE IF EXISTS totalSalary;
CREATE TABLE totalSalary(
	employeeID VARCHAR(30),
	curMonth DATE,
	basicSalary DOUBLE(10,2),
	OTAmountAll DOUBLE(10,2),
	DOTAmountAll DOUBLE(10,2),
	NoPayAmountAll DOUBLE(10,2),
	lateComingAmountAll DOUBLE(10,2),
	totSal DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeID, curMonth)
);

#*******************************************************************************

DROP TABLE IF EXISTS ETF_EPF_Rate;
CREATE TABLE ETF_EPF_Rate(
	ETF_EPF_RateID VARCHAR(30),
	rate DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(ETF_EPF_RateID)
);

INSERT INTO ETF_EPF_Rate VALUES
	("ETF",3),
	("EPF",12);

#*******************************************************************************

DROP TABLE IF EXISTS ETF;
CREATE TABLE ETF(
	employeeID VARCHAR(30),
	curMonth DATE,
	ETF_EPF_RateID VARCHAR(30),
	ETFAmount DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeID, curMonth),
	CONSTRAINT FOREIGN KEY(ETF_EPF_RateID) REFERENCES ETF_EPF_Rate(ETF_EPF_RateID)
);

#*******************************************************************************

DROP TABLE IF EXISTS EPF;
CREATE TABLE EPF(
	employeeID VARCHAR(30),
	curMonth DATE,
	ETF_EPF_RateID VARCHAR(30),
	EPFAmount DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeID, curMonth),
	CONSTRAINT FOREIGN KEY(ETF_EPF_RateID) REFERENCES ETF_EPF_Rate(ETF_EPF_RateID)
);

#*******************************************************************************

DROP TABLE IF EXISTS grossSalary;
CREATE TABLE grossSalary(
	employeeID VARCHAR(30),
	curMonth DATE,
	totSalary DOUBLE(10,2),
	ETFAmount DOUBLE(10,2),
	EPFAmount DOUBLE(10,2),
	grossSal DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeID, curMonth)
);

#*******************************************************************************

DROP TABLE IF EXISTS incomeTaxRate;
CREATE TABLE incomeTaxRate(
	incomeTaxRateID VARCHAR(30),
	minAmount DOUBLE(10,2),
	maxAmount DOUBLE(10,2),
	rate DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(incomeTaxRateID)
);

#*******************************************************************************

DROP TABLE IF EXISTS incomeTax;
CREATE TABLE incomeTax(
	employeeID VARCHAR(30),
	curMonth DATE,
	incomeTaxAmount DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeID, curMonth)
);

#*******************************************************************************

DROP TABLE IF EXISTS netSalary;
CREATE TABLE netSalary(
	employeeID VARCHAR(30),
	curMonth DATE,
	netSal DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeID, curMonth)
);

#*******************************************************************************
DROP TABLE IF EXISTS userPass;
CREATE TABLE userpass(
	username VARCHAR(30),
	password VARCHAR(30),
	CONSTRAINT PRIMARY KEY(username, password)
);

INSERT INTO userPass VALUES
	("admin","admin"),
	("user","password");

#*******************************************************************************

#<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< End >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

