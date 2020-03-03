package com.gtl.fm.db.dao;

import java.util.List;

import com.gtl.fm.db.entities.Driver;


public interface DriverDao {

	List<Driver> getDriver();
	
	Driver getDriver(int id);
	
	Driver saveDriver(Driver driver);
	
	Driver deleteDriver(int id);
	
	List<Driver> getDeletedDrivers();
}
