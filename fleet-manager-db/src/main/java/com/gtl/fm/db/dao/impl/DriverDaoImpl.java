package com.gtl.fm.db.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.gtl.fm.db.dao.DriverDao;
import com.gtl.fm.db.entities.Driver;

@Repository
public class DriverDaoImpl extends GenericDaoImpl<Driver> implements DriverDao{

	Logger logger = LoggerFactory.getLogger(AuthDaoImpl.class);
	
	@Override
	public List<Driver> getDriver() {
		List<Driver> affectedDriver = null;
		try {
			boolean activeFlag = true;
			affectedDriver = createQuery("from Driver where isActive = :deleteFlag",Driver.class)
					         .setParameter("deleteFlag", activeFlag)
					         .getResultList();
		}catch (NoResultException ex) {
			logger.error("Failed to find a drivers!");
		}
//		try {
//			affectedDriver = findAll();
//		}catch (NoResultException ex) {
//			logger.error("Failed to find a drivers ");
//		}
		return affectedDriver;
	}

	@Override
	public Driver getDriver(int id) {
		Driver affectedDriver = null;
		try {
			boolean activeFlag = true;
			affectedDriver =  createQuery("from Driver where id = :Id and isActive = :activeFlag",Driver.class)
							  .setParameter("Id", id)			
							  .setParameter("activeFlag", activeFlag)
							  .getSingleResult();
			
		}
		catch(NoResultException ex) {
			logger.error("Failed to find a driver");
			return null;
		}
		return affectedDriver;
	}

	@Override
	public Driver saveDriver(Driver driver) {
		driver.setActive(true);
		try {
			if(driver.getId() != null) {
				update(driver);
			}
			else{
				save(driver);
			}
		}catch(Exception ex){
			logger.error("Failed to save or update  driver");
			return null;
		}
		return driver;
	}


	@Override
	public Driver deleteDriver(int id) {
		Driver affectedDriver = null;
		try {
			affectedDriver =  findById(id);
			affectedDriver.setActive(false);
			update(affectedDriver);
			return affectedDriver;
		}
		catch(Exception ex) {
			logger.error("Faild to delete driver with id {}",id);
			return null;
		}
	}

	@Override
	public List<Driver> getDeletedDrivers(){
		List<Driver> affectedDrivers = null;
		try {
			boolean deleteFlag = false;
			affectedDrivers = createQuery("from Driver where isActive = :deleteFlag",Driver.class)
					         .setParameter("deleteFlag", deleteFlag)
					         .getResultList();
		}catch (NoResultException ex) {
			logger.error("Failed to find a drivers!");
		}
		return affectedDrivers;
	}
	
	//find driver by id
	@Override
	public Driver findByEmail(String email) {
		Driver driver = null;
		try {
			driver =  createQuery("from Driver where email =:email ",Driver.class)
					  .setParameter("email",email)
					  .getSingleResult();
		}catch (NoResultException ex) {
			logger.error("Drivers email : {} is already in the database",email);
		}
		return driver;
	}

	
}
