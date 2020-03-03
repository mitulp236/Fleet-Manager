package com.gtl.fm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gtl.fm.db.dao.DriverDao;
import com.gtl.fm.db.entities.Driver;
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

	@Override
	@Transactional
	public Driver getDriver(int id) {
		return this.driverDao.getDriver(id);
	}

	@Override
	@Transactional
	public Driver saveDriver(Driver driver) {
		return this.driverDao.saveDriver(driver);
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


}
