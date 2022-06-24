
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
	("AL-001","As foodAL=5000.00, transportAL=2000.00 & accommodationAL=5000.00",12000.00),
	("AL-002","As foodAL=5000.00, transportAL=2000.00 & accommodationAL=4000.00",11000.00),
	("AL-003","As foodAL=4000.00, transportAL=2000.00 & accommodationAL=4000.00",10000.00),
	("AL-004","As foodAL=4000.00, transportAL=1500.00 & accommodationAL=3000.00",8500.00),
	("AL-005","As foodAL=3500.00, transportAL=1500.00 & accommodationAL=2000.00",7000.00),
	("AL-006","As foodAL=3000.00, transportAL=1500.00 & accommodationAL=2000.00",6500.00);


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
	("ET-001","AL-001","Manager","This is the Manager with AllowanceID AL001",56000.00),
	("ET-002","AL-002","assistance Manager","This is the Assistance manager with AllowanceID AL002",40000.00),
	("ET-003","AL-003","Supervisor","This is the Supervisor with AllowanceID AL003",36000.00),
	("ET-004","AL-003","Assistan Supervisor","This is the Assistance Supervisor with AllowanceID AL003",30000.00),
	("ET-005","AL-004","Clark","This is the Clark with AllowanceID AL004",25000.00),
	("ET-006","AL-005","Labor","This is the Labor with AllowanceID AL005",20000.00);
	

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
	("EMP-0001","ET-001","Mr.Kasun","759687452V","56","Salmal Road","Wawala","Nagoda","0342256751","0718936478","otherDetails_Kasun"),
	("EMP-0002","ET-005","Mr.Piyal","812345796V","23/4","Second Lane","Seelama","Beruwala","0345689712","0775698312","otherDetails_Piyal"),
	("EMP-0003","ET-006","Mrs.Ruvini","925678412V","12/A","Barton Place","Pinwatta","Panadura","0382246912","0719863145","otherDetails_Ruvini"),
	("EMP-0004","ET-002","Mrs.Nadeeka","869574125V","246","Sirimewan Road","Villegoda","Dodangoda","0345896712","0759687468","otherDetails_Nadeeka"),
	("EMP-0005","ET-006","Mr.Madawa","895674125V","88/3","Samagi Road","Panapitiya","Horana","0342296872","0714589687","otherDetails_Madawa");

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
	empID VARCHAR(30),
	CDate DATE,
	leaveType VARCHAR(30),
	in_Time TIME,
	out_Time TIME,
	CONSTRAINT PRIMARY KEY(empID, CDate)
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
	("ODR-01","ET-001",300.00,500.00),
	("ODR-02","ET-002",250.00,400.00),
	("ODR-03","ET-003",200.00,350.00),
	("ODR-04","ET-004",150.00,300.00),
	("ODR-05","ET-005",120.00,250.00),
	("ODR-06","ET-006",90.00,180.00);

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
	LCAmount DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeID, curDate)
);


#*******************************************************************************

DROP TABLE IF EXISTS totalSalary;
CREATE TABLE totalSalary(
	employeeID VARCHAR(30),
	curMonth VARCHAR(30),
	basicSalary DOUBLE(10,2),
	NoPayAll DOUBLE(10,2),
	OTAmountAll DOUBLE(10,2),
	DOTAmountAll DOUBLE(10,2),
	LCAmountAll DOUBLE(10,2),
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
	empID VARCHAR(30),
	CMonth VARCHAR(30),
	ETF_EPF_RateID VARCHAR(30),
	ETFAmount DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(empID, CMonth),
	CONSTRAINT FOREIGN KEY(ETF_EPF_RateID) REFERENCES ETF_EPF_Rate(ETF_EPF_RateID)
);

#*******************************************************************************

DROP TABLE IF EXISTS EPF;
CREATE TABLE EPF(
	empID VARCHAR(30),
	CMonth VARCHAR(30),
	ETF_EPF_RateID VARCHAR(30),
	EPFAmount DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(empID, CMonth),
	CONSTRAINT FOREIGN KEY(ETF_EPF_RateID) REFERENCES ETF_EPF_Rate(ETF_EPF_RateID)
);

#*******************************************************************************

DROP TABLE IF EXISTS grossSalary;
CREATE TABLE grossSalary(
	empID VARCHAR(30),
	CMonth VARCHAR(30),
	totSalary DOUBLE(10,2),
	ETFAmount DOUBLE(10,2),
	EPFAmount DOUBLE(10,2),
	grossSal DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(empID, CMonth)
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

INSERT INTO incomeTaxRate VALUES
	("ITR-001", 0.00, 100000.00, 0.00),
	("ITR-002", 100000.00, 150000.00, 4.00),
	("IT-003", 150000.00, 250000.00, 8.00),
	("IT-004", 250000.00, 300000.00, 12.00),
	("IT-005", 300000.00, 350000.00, 16.00);
	

#*******************************************************************************

DROP TABLE IF EXISTS incomeTax;
CREATE TABLE incomeTax(
	employeeID VARCHAR(30),
	curMonth VARCHAR(30),
	incomeTaxAmount DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeID, curMonth)
);

#*******************************************************************************

DROP TABLE IF EXISTS netSalary;
CREATE TABLE netSalary(
	empID VARCHAR(30),
	CMonth VARCHAR(30),
	netSal DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(empID, CMonth)
);

DROP PROCEDURE IF EXISTS getAllSalarys;
DELIMITER $$;
CREATE PROCEDURE getAllSalarys()
BEGIN
select empID,CMonth,netSal from netSalary;
END$$;
DELIMITER ;


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
	
	
#******************procedures and triggers*******************************

#userPass table
#^^^^^^^^^^^^^^^^^^^^
#-------------------verify userPass------------------------------
DROP PROCEDURE IF EXISTS verifyUserPass;
DELIMITER $$;
CREATE PROCEDURE verifyUserPass(
IN username_vbl VARCHAR(30),
IN password_vbl VARCHAR(30)
)
BEGIN
select * from userpass where username=username_vbl and password=password_vbl;
END$$;
DELIMITER ;

#employeeType table
#^^^^^^^^^^^^^^^^^^^^
#-----------------------return All Employee Types------------------------------
DROP PROCEDURE IF EXISTS getAllEmployeeTypes;
DELIMITER $$;
CREATE PROCEDURE getAllEmployeeTypes()
BEGIN
select * from employeeType;
END$$;
DELIMITER ;

#----------------------return Employee Type Name----------------------------
DROP FUNCTION IF EXISTS getEmployeeTypeName;
DELIMITER $$;
CREATE FUNCTION getEmployeeTypeName(employeeTypeID_vbl VARCHAR(30)) returns text
DETERMINISTIC
READS SQL DATA
BEGIN
DECLARE employeeTypeName VARCHAR(30);
select name from employeeType where employeeTypeID=employeeTypeID_vbl into employeeTypeName;
RETURN employeeTypeName;
END$$;
DELIMITER ;	

#employee table
#^^^^^^^^^^^^^^^^^^^^
#-------------------get All Employees Details------------------------------
DROP PROCEDURE IF EXISTS getAllEmployees;
DELIMITER $$;
CREATE PROCEDURE getAllEmployees()
BEGIN
select * from employee;
END$$;
DELIMITER ;

#-------------------get an Employee Details------------------------------
DROP PROCEDURE IF EXISTS getAnEmployee;
DELIMITER $$;
CREATE PROCEDURE getAnEmployee(
IN employeeID_vbl VARCHAR(30)
)
BEGIN
select * from employee where employeeID=employeeID_vbl;
END$$;
DELIMITER ;

#-----------------------------Save an Employee----------------------------
DROP PROCEDURE IF EXISTS saveEmployee;
DELIMITER $$;
CREATE PROCEDURE saveEmployee(
IN employeeID_vbl VARCHAR(30),
IN employeeTypeName_vbl VARCHAR(60),
IN name_vbl VARCHAR(60),
IN nic_vbl VARCHAR(15),
IN address_no_vbl VARCHAR(30),
IN address_street_vbl VARCHAR(30),
IN address_village_vbl VARCHAR(30),
IN address_city_vbl VARCHAR(30),
IN contactNo_home_vbl VARCHAR(15),
IN contactNo_mobile_vbl VARCHAR(15),
IN other_detail_vbl VARCHAR(60)
)
BEGIN
DECLARE employeeTypeID_vbl VARCHAR(30);
select employeeTypeID from employeeType where name=employeeTypeName_vbl into employeeTypeID_vbl;
insert into employee values(employeeID_vbl, employeeTypeID_vbl, name_vbl, nic_vbl, address_no_vbl, address_street_vbl, address_village_vbl, address_city_vbl, contactNo_home_vbl, contactNo_mobile_vbl, other_detail_vbl);
END$$;
DELIMITER ;

#-----------------------------Update an Employee-----------------------
DROP PROCEDURE IF EXISTS updateEmployee;
DELIMITER $$;
CREATE PROCEDURE updateEmployee(
IN employeeTypeName_vbl VARCHAR(60),
IN name_vbl VARCHAR(60),
IN nic_vbl VARCHAR(15),
IN address_no_vbl VARCHAR(30),
IN address_street_vbl VARCHAR(30),
IN address_village_vbl VARCHAR(30),
IN address_city_vbl VARCHAR(30),
IN contactNo_home_vbl VARCHAR(15),
IN contactNo_mobile_vbl VARCHAR(15),
IN other_detail_vbl VARCHAR(60),
IN employeeID_vbl VARCHAR(30)
)
BEGIN
DECLARE employeeTypeID_vbl VARCHAR(30);
select employeeTypeID from employeeType where name=employeeTypeName_vbl into employeeTypeID_vbl;
update employee set employeeTypeID=employeeTypeID_vbl,
					name=name_vbl,
					nic=nic_vbl,
					address_no=address_no_vbl,
					address_street=address_street_vbl,
					address_village=address_village_vbl,
					address_city=address_city_vbl,
					contactNo_home=contactNo_home_vbl,
					contactNo_mobile=contactNo_mobile_vbl,
					other_detail=other_detail_vbl
where employeeID=employeeID_vbl;
END$$;
DELIMITER ;

#-----------------------Delete an Employee----------------------------
DROP PROCEDURE IF EXISTS deleteEmployee;
DELIMITER $$;
CREATE PROCEDURE deleteEmployee(
IN employeeID_vbl VARCHAR(30)
)
BEGIN
delete from employee where employeeID=employeeID_vbl;
END$$;
DELIMITER ;

#-----------------------------Search Employees----------------------------
DROP PROCEDURE IF EXISTS searchEmployees;
DELIMITER $$;
CREATE PROCEDURE searchEmployees(
IN searchText VARCHAR(30)
)
BEGIN
DECLARE newSearchText VARCHAR(30);
set newSearchText=concat("%",searchText,"%");
SELECT * from employee where employeeID like newSearchText or name like newSearchText or nic like newSearchText;
END$$;
DELIMITER ;

#---------------------------------Get Last Employee ID-----------------
DROP FUNCTION IF EXISTS getLastEmployeeID;
DELIMITER $$;
CREATE FUNCTION getLastEmployeeID() returns text
DETERMINISTIC
READS SQL DATA
BEGIN
DECLARE lastEmployeeID VARCHAR(30);
select employeeID from employee order by 1 desc limit 1 into lastEmployeeID;
RETURN lastEmployeeID;
END$$;
DELIMITER ;	

#attendance table
#^^^^^^^^^^^^^^^^^^^^
#-----------------------------return All In Out Records------------------------
DROP PROCEDURE IF EXISTS getAllInOutRecods;
DELIMITER $$;
CREATE PROCEDURE getAllInOutRecods()
BEGIN
select * from attendance;
END$$;
DELIMITER ;

#------------------procedure to add incomeTax Rate and Net Amount----------------------------
DROP PROCEDURE IF EXISTS addITaxAndNetSal;
DELIMITER $$;
CREATE PROCEDURE addITaxAndNetSal(
IN employeeID_vbl VARCHAR(30),
IN curMonth_vbl VARCHAR(30),
IN grossSalary_vbl DOUBLE(10,2)
)
BEGIN
	DECLARE ITaxRate DOUBLE(10,2);
	DECLARE ITaxAmount DOUBLE(10,2);
	DECLARE netSal_vbl DOUBLE(10,2);
	BEGIN
		ROLLBACK;
	END;
		select rate into ITaxRate from incomeTaxRate where grossSalary_vbl>minAmount and grossSalary_vbl<maxAmount;
		set ITaxAmount=grossSalary_vbl*ITaxRate/100;
		set netSal_vbl=grossSalary_vbl-ITaxAmount;
	START TRANSACTION;
		insert into incomeTax values(employeeID_vbl, curMonth_vbl, ITaxAmount);
		insert into netSalary values(employeeID_vbl, curMonth_vbl, netSal_vbl);
	COMMIT;
END$$;
DELIMITER ;


#------------------procedure to update incomeTax Rate and Net Amount----------------------------
DROP PROCEDURE IF EXISTS updateITaxAndNetSal;
DELIMITER $$;
CREATE PROCEDURE updateITaxAndNetSal(
IN employeeID_vbl VARCHAR(30),
IN curMonth_vbl VARCHAR(30),
IN grossSalary_vbl DOUBLE(10,2)
)
BEGIN
	DECLARE ITaxRate DOUBLE(10,2);
	DECLARE ITaxAmount DOUBLE(10,2);
	DECLARE netSal_vbl DOUBLE(10,2);
	BEGIN
		ROLLBACK;
	END;
		select rate into ITaxRate from incomeTaxRate where grossSalary_vbl>minAmount and grossSalary_vbl<maxAmount;
		set ITaxAmount=grossSalary_vbl*ITaxRate/100;
		set netSal_vbl=grossSalary_vbl-ITaxAmount;
	START TRANSACTION;
		update incomeTax set
			incomeTaxAmount=ITaxAmount
			where employeeID=employeeID_vbl and curMonth=curMonth_vbl;
	
		update netSalary set
			netSal=netSal_vbl
			where employeeID=employeeID_vbl and curMonth=curMonth_vbl;
		COMMIT;
END$$;
DELIMITER ;


#--------------------Trigger to add employee leave--------------------
DROP TRIGGER IF EXISTS addEmployeeLeave;
DELIMITER $$
CREATE TRIGGER addEmployeeLeave BEFORE UPDATE ON attendance
FOR EACH ROW
BEGIN
	DECLARE isExists INT(10);
	set isExists=exists(select * from empLeave where empID=new.employeeID and CDate=new.curDate);
	
	IF ( isExists<1 and hour(outTime)+(minute(outTime)/60))>11.5 and (hour(outTime)+(minute(outTime)/60))<12.5 THEN
		insert into empLeave set
			empID=new.employeeID,
			CDate=new.curDate,
			leaveType='Short Leave',
			in_Time=new.inTime,
			out_Time=new.outTime;
	ELSE
		update empLeave set
		leaveType='Short Leave',
		in_Time=new.inTime,
		out_Time=new.outTime
		where empID=new.employeeID and
		CDate=new.curDate;
	END IF;
END$$
DELIMITER ;

#-------------Trigger to add EPF, ETF & Gross Salary---------------
DROP TRIGGER IF EXISTS addEpfEtfGrossSal;
DELIMITER $$
CREATE TRIGGER addEpfEtfGrossSal BEFORE INSERT ON totalSalary
FOR EACH ROW
BEGIN
	DECLARE ETFRate_vbl DOUBLE(10,2);
	DECLARE EPFRate_vbl DOUBLE(10,2);
	DECLARE empID_vbl VARCHAR(30);
	DECLARE CMonth_vbl VARCHAR(30);
	DECLARE grossSal_vbl DOUBLE(10,2);
	
	select rate into ETFRate_vbl from ETF_EPF_Rate where ETF_EPF_RateID='ETF';
	select rate into EPFRate_vbl from ETF_EPF_Rate where ETF_EPF_RateID='EPF';
	
	insert into ETF set
		empID=new.employeeID,
		CMonth=new.curMonth,
		ETF_EPF_RateID='ETF',
		ETFAmount=new.totSal*ETFRate_vbl/100;
		
	insert into EPF set
		empID=new.employeeID,
		CMonth=new.curMonth,
		ETF_EPF_RateID='EPF',
		EPFAmount=new.totSal*EPFRate_vbl/100;
	
	insert into grossSalary set
		empID=new.employeeID,
		CMonth=new.curMonth,
		totSalary=new.totSal,
		ETFAmount=new.totSal*ETFRate_vbl/100,
		EPFAmount=new.totSal*EPFRate_vbl/100,
		grossSal=new.totSal-(new.totSal*ETFRate_vbl/100);
		
	set empID_vbl=new.employeeID;
	set CMonth_vbl=new.curMonth;
	set grossSal_vbl=new.totSal-(new.totSal*ETFRate_vbl/100);
		
	call addITaxAndNetSal(empID_vbl, CMonth_vbl, grossSal_vbl);
	
END$$
DELIMITER ;

#-------------Trigger to update EPF, ETF & Gross Salary---------------
DROP TRIGGER IF EXISTS updateEpfEtfGrossSal;
DELIMITER $$
CREATE TRIGGER updateEpfEtfGrossSal BEFORE UPDATE ON totalSalary
FOR EACH ROW
BEGIN
	DECLARE ETFRate_vbl DOUBLE(10,2);
	DECLARE EPFRate_vbl DOUBLE(10,2);
	DECLARE empID_vbl VARCHAR(30);
	DECLARE CMonth_vbl VARCHAR(30);
	DECLARE grossSal_vbl DOUBLE(10,2);
	
	select rate into ETFRate_vbl from ETF_EPF_Rate where ETF_EPF_RateID='ETF';
	select rate into EPFRate_vbl from ETF_EPF_Rate where ETF_EPF_RateID='EPF';
	
	update ETF set
		ETF_EPF_RateID='ETF',
		ETFAmount=new.totSal*ETFRate_vbl/100
		where empID=new.employeeID and CMonth=new.curMonth;
		
	update EPF set
		ETF_EPF_RateID='EPF',
		EPFAmount=new.totSal*EPFRate_vbl/100
		where empID=new.employeeID and CMonth=new.curMonth;
	
	update grossSalary set
		totSalary=new.totSal,
		ETFAmount=new.totSal*ETFRate_vbl/100,
		EPFAmount=new.totSal*EPFRate_vbl/100,
		grossSal=new.totSal-(new.totSal*ETFRate_vbl/100)
		where empID=new.employeeID and CMonth=new.curMonth;
		
	set empID_vbl=new.employeeID;
	set CMonth_vbl=new.curMonth;
	set grossSal_vbl=new.totSal-(new.totSal*ETFRate_vbl/100);

		
	call updateITaxAndNetSal(empID_vbl, CMonth_vbl, grossSal_vbl);
END$$
DELIMITER ;



#---------------------------save a In Out Record-------------------------------
DROP PROCEDURE IF EXISTS saveInOutRecord;
DELIMITER $$;
CREATE PROCEDURE saveInOutRecord(
IN employeeID_vbl VARCHAR(30),
IN curDate_vbl DATE,
IN inTime_vbl TIME,
IN outTime_vbl TIME
)
BEGIN
	DECLARE OT_DOT_RateID_vbl VARCHAR(30);
	DECLARE OTAmount_vbl DOUBLE(10,2);
	DECLARE DOTAmount_vbl DOUBLE(10,2);
	DECLARE LCAmount_vbl DOUBLE(10,2);
	DECLARE isWantLC INTEGER(10);
	DECLARE EXIT handler FOR SQLEXCEPTION
	BEGIN
		ROLLBACK;
	END;
		select OT_DOT_RateID from OT_DOT_Rate where employeeTypeID=(
			select employeeTypeID from employee where employeeID=employeeID_vbl
		) into OT_DOT_RateID_vbl;
		
		IF (hour(inTime_vbl)+(minute(inTime_vbl)/60))>8.5 THEN
			set isWantLC=1;
			set LCAmount_vbl=150;
		ELSE
			set isWantLC=0;
		END IF;
		
		
	START TRANSACTION;
		insert into attendance values(employeeID_vbl, curDate_vbl, inTime_vbl, outTime_vbl);
		insert into OT values(employeeID_vbl, curDate_vbl, OT_DOT_RateID_vbl, OTAmount_vbl);
		insert into DOT values(employeeID_vbl, curDate_vbl, OT_DOT_RateID_vbl, DOTAmount_vbl);
		IF isWantLC>0 THEN
			insert into lateComing values(employeeID_vbl, curDate_vbl, inTime_vbl, LCAmount_vbl);
		END IF;
	COMMIT;
END$$;
DELIMITER ;

#-----------------------------update a In Out Record--------------------------
DROP TABLE IF EXISTS totalSalary;
CREATE TABLE totalSalary(
	employeeID VARCHAR(30),
	curMonth VARCHAR(30),
	basicSalary DOUBLE(10,2),
	OTAmountAll DOUBLE(10,2),
	DOTAmountAll DOUBLE(10,2),
	LCAmountAll DOUBLE(10,2),
	totSal DOUBLE(10,2),
	CONSTRAINT PRIMARY KEY(employeeID, curMonth)
);


DROP PROCEDURE IF EXISTS updateInOutRecord;
DELIMITER $$;
CREATE PROCEDURE updateInOutRecord(
IN employeeID_vbl VARCHAR(30),
IN curDate_vbl DATE,
IN inTime_vbl TIME,
IN outTime_vbl TIME
)
BEGIN
	DECLARE OT_DOT_RateID_vbl VARCHAR(30);
	DECLARE isWantOT INTEGER(10);
	DECLARE OTAmount_vbl DOUBLE(10,2);
	DECLARE isWantDOT INTEGER(10);
	DECLARE DOTAmount_vbl DOUBLE(10,2);
	DECLARE LCAmount_vbl DOUBLE(10,2);
	DECLARE curMonth_vbl VARCHAR(30);
	DECLARE basicSalary_vbl DOUBLE(10,2);
	DECLARE isExists_totSal INTEGER(10);
	DECLARE basicSalary_all DOUBLE(10,2);
	DECLARE OTAmount_all DOUBLE(10,2);
	DECLARE DOTAmount_all DOUBLE(10,2);
	DECLARE LCAmount_all DOUBLE(10,2);
    	DECLARE totSal_vbl DOUBLE(10,2);
	DECLARE totSal_all DOUBLE(10,2);
	DECLARE EXIT handler FOR SQLEXCEPTION
	BEGIN
		ROLLBACK;
	END;
		set OT_DOT_RateID_vbl=(select OT_DOT_RateID from OT_DOT_Rate where employeeTypeID=(select employeeTypeID from employee where employeeID=employeeID_vbl));
		
		
		IF(hour(outTime_vbl)+(minute(outTime_vbl)/60))>17 or dayname(curDate_vbl)!='sunday' THEN
			set isWantOT=1;
			set OTAmount_vbl=(select OTRate from OT_DOT_Rate where OT_DOT_RateID=OT_DOT_RateID_vbl)*((hour(outTime_vbl)+(minute(outTime_vbl)/60))-17);
		ELSE
			set isWantOT=0;
			set OTAmount_vbl=0;
		END IF;
		
		
		IF dayname(curDate_vbl)='sunday' THEN
			set isWantDOT=1;
			set DOTAmount_vbl=(select DOTRate from OT_DOT_Rate where OT_DOT_RateID=OT_DOT_RateID_vbl)*((hour(outTime_vbl)+(minute(outTime_vbl)/60))-(hour(inTime_vbl)+(minute(inTime_vbl)/60)));
		ELSE
			set isWantDOT=0;
			set DOTAmount_vbl=0;
		END IF;
		
		
		IF (hour(inTime_vbl)+(minute(inTime_vbl)/60))>8.5 THEN
			set LCAmount_vbl=150;
		ELSE
			set LCAmount_vbl=0;
		END IF;
		
		
		set curMonth_vbl=monthname(curDate_vbl);
		
		
		IF (hour(outTime_vbl)+(minute(outTime_vbl)/60))>11.5 and (hour(outTime_vbl)+(minute(outTime_vbl)/60))<12.5 THEN
			set basicSalary_vbl=(select basicSalary from employeeType where employeeTypeID=(select employeeTypeID from employee where employeeID=employeeID_vbl))/60;
		ELSE
			set basicSalary_vbl=(select basicSalary from employeeType where employeeTypeID=(select employeeTypeID from employee where employeeID=employeeID_vbl))/30;
		END IF;
		
		set isExists_totSal=exists(select * from totalSalary where employeeID=employeeID_vbl and curMonth=curMonth_vbl);
		
		
		IF isExists_totSal>0 THEN
			set basicSalary_all=(select basicSalary from totalSalary where employeeID=employeeID_vbl and curMonth=curMonth_vbl)+basicSalary_vbl;
		ELSE
			set basicSalary_all=basicSalary_vbl;
		END IF;
		
		
		set OTAmount_all=(select OTAmountAll from totalSalary where employeeID=employeeID_vbl and curMonth=curMonth_vbl)+OTAmount_vbl;
		
		set DOTAmount_all=(select DOTAmountAll from totalSalary where employeeID=employeeID_vbl and curMonth=curMonth_vbl)+DOTAmount_vbl;
		
		set LCAmount_all=(select LCAmountAll from totalSalary where employeeID=employeeID_vbl and curMonth=curMonth_vbl)+LCAmount_vbl;
        
        	set totSal_vbl=basicSalary_vbl+OTAmount_vbl+DOTAmount_vbl-LCAmount_vbl;
		
		set totSal_all=basicSalary_all+OTAmount_all+DOTAmount_all-LCAmount_all;
		
		
	START TRANSACTION;
		update attendance set inTime=inTime_vbl,
							outTime=outTime_vbl
		where employeeID=employeeID_vbl and curDate=curDate_vbl;


		IF isWantOT>0 THEN
			update OT set OT_DOT_RateID=OT_DOT_RateID_vbl,
						OTAmount=OTAmount_vbl
			where employeeID=employeeID_vbl and curDate=curDate_vbl;
		ELSE
			delete from OT where employeeID=employeeID_vbl and curDate=curDate_vbl;
		END IF;
        
        IF isWantDOT>0 THEN
			update DOT set OT_DOT_RateID=OT_DOT_RateID_vbl,
						DOTAmount=DOTAmount_vbl
			where employeeID=employeeID_vbl and curDate=curDate_vbl;
		ELSE
			delete from DOT where employeeID=employeeID_vbl and curDate=curDate_vbl;
		END IF;
		
		
		IF isExists_totSal<1 THEN  
			insert into totalSalary values(
				employeeID_vbl,
				curMonth_vbl,
				basicSalary_vbl,
				OTAmount_vbl,
				DOTAmount_vbl,
				LCAmount_vbl,
				totSal_vbl
			);
		ELSE
			update totalSalary set basicSalary=basicSalary_all,
									OTAmountAll=OTAmount_all,
									DOTAmountAll=DOTAmount_all,
									LCAmountAll=LCAmount_all,
									totSal=totSal_all
			where employeeID=employeeID_vbl and curMonth=curMonth_vbl;
		END IF;
		
	COMMIT;
END$$;
DELIMITER ;


#*******************************************************************************



#<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< End >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

