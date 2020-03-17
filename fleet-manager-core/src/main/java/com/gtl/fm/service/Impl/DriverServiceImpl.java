package com.gtl.fm.service.Impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gtl.fm.core.exception.DataNotFoundException;
import com.gtl.fm.core.exception.EmailAlreadyUsedException;
import com.gtl.fm.core.exception.ValidationException;
import com.gtl.fm.db.dao.DriverDao;
import com.gtl.fm.db.entities.Driver;
import com.gtl.fm.db.exception.RequestedEmailNotAvailableException;
import com.gtl.fm.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverDao driverDao;
	
	// LIST OF DRIVERS
	@Override
	@Transactional
	public List<Driver> getDriver() {
		return this.driverDao.getDriver();	
	}
	
	// FIND BY ID
	@Override
	@Transactional
	public Driver getDriver(int id) {
		Driver driver = this.driverDao.getDriver(id);
		if(driver != null) {
			return driver;
		}
		throw new DataNotFoundException("Driver with id "+id+"is not found ! ");
		
	}
	//
	//SAVE OR UPDATE DRIVER
	@Override
	@Transactional
	public Driver saveDriver(Driver driver) {
		try {
			//validate the data
			if(driver.getTitle() == null) {throw new ValidationException("Title is empty",1008);}
			if(driver.getFirstName() == null || Pattern.matches("^[A-Za-z]+$",driver.getFirstName()) == false) {throw new ValidationException("FirstName is empty or not valid",1009);}
			if(driver.getLastName() == null || Pattern.matches("^[A-Za-z]+$",driver.getLastName()) == false ) {throw new ValidationException("LastName is empty or not valid",1010);}
			if(driver.getDob() == null) {throw new ValidationException("DOB is empty",1011);}
			if(driver.getEmail() == null || Pattern.matches("^(.+)@(.+)$",driver.getEmail()) == false) {throw new ValidationException("Email is empty or not valid",1012);}
			if(driver.getAddress() == null) {throw new ValidationException("Address is empty",1013);}
			if(driver.getCity() == null) {throw new ValidationException("City is empty",1014);}
			if(driver.getPostcode() == null) {throw new ValidationException("PostCode is empty",1015);}
			
			//capitalize the first name,last name,middle name
			driver.setFirstName(driver.getFirstName().substring(0,1).toUpperCase() + driver.getFirstName().substring(1).toLowerCase());
			driver.setLastName(driver.getLastName().substring(0,1).toUpperCase() + driver.getLastName().substring(1).toLowerCase());
			
			//validate and capitalize the middle name
			if(driver.getMiddleName()!=null) {
				if(Pattern.matches("^[A-Za-z]+$",driver.getMiddleName()) == false ) {
					throw new ValidationException("MiddleName is Not Valid",1016);
				}
				driver.setMiddleName(driver.getMiddleName().substring(0,1).toUpperCase() + driver.getMiddleName().substring(1).toLowerCase());
			}
			
			// returning affected driver
			return this.driverDao.saveDriver(driver);
			
		}catch (RequestedEmailNotAvailableException ex) {
			//throw an exception if the driver already exist with given email
			throw new EmailAlreadyUsedException(driver.getEmail()+" is already used ! try with other email");
		}
	}


	//DELETE DRIVER
	@Override
	@Transactional
	public Driver deleteDriver(int id) {
		return this.driverDao.deleteDriver(id);
	}

	//LIST OF DELETED DRIVERS
	@Override
	@Transactional
	public List<Driver> getDeletedDrivers() {
		return this.driverDao.getDeletedDrivers();
	}

	//FIND BY EMAIL
	@Override
	@Transactional
	public Driver findByEmail(String email) {
		Driver driver = this.driverDao.findByEmail(email);
		if(driver != null) {
			throw new EmailAlreadyUsedException("Driver with email: "+email+" already exist !");
		}
		return null;
	}
	
}
