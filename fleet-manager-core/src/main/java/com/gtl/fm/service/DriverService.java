package com.gtl.fm.service;

import java.util.List;

import com.gtl.fm.db.entities.Driver;

public interface DriverService {

	List<Driver> getDriver();
	
	Driver getDriver(int id);
	
	Driver saveDriver(Driver driver);
	
	Driver deleteDriver(int id);
	
	List<Driver> getDeletedDrivers();
	
	
}
