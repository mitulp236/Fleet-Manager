package com.gtl.fm.service;

import java.util.List;

import com.gtl.fm.db.entities.Driver;

public interface DriverService {

	List<Driver> getDrivers(Integer start,String sortBy,String serchBy,String serchString);
	
	Long getPages();
	
	List<Driver> getAllDrivers();
	
	List<Driver> getDriver(int id);
	
	Driver saveDriver(Driver driver);
	
	Driver deleteDriver(int id);
	
	List<Driver> getDeletedDrivers();
	
	Driver findByEmail(String email);
	
	
}
