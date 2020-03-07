package com.gtl.fm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gtl.fm.core.exception.DataNotFoundException;
import com.gtl.fm.core.exception.EmailAlreadyUsedException;
import com.gtl.fm.db.dao.DriverDao;
import com.gtl.fm.db.entities.Driver;
import com.gtl.fm.db.exception.RequestedEmailNotAvailableException;
import com.gtl.fm.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverDao driverDao;
	
	@Override
	@Transactional
	public List<Driver> getDriver() {
		return this.driverDao.getDriver();
	}

//	@Override
//	@Transactional
//	public Driver getDriver(int id) {
//		return this.driverDao.getDriver(id);
//	}
	
	@Override
	@Transactional
	public Driver getDriver(int id) {
		Driver driver = this.driverDao.getDriver(id);
		if(driver != null) {
			return driver;
		}
		throw new DataNotFoundException("Driver with id "+id+"is not found ! ");
		
	}
	
	@Override
	@Transactional
	public Driver saveDriver(Driver driver) {
		try {
			return this.driverDao.saveDriver(driver);
		}catch (RequestedEmailNotAvailableException ex) {
			throw new EmailAlreadyUsedException(driver.getEmail()+" is already used ! try with other email");
		}
	}


	@Override
	@Transactional
	public Driver deleteDriver(int id) {
		return this.driverDao.deleteDriver(id);
	}

	@Override
	@Transactional
	public List<Driver> getDeletedDrivers() {
		return this.driverDao.getDeletedDrivers();
	}

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
