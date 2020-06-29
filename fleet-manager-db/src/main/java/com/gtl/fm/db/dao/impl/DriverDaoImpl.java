package com.gtl.fm.db.dao.impl;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.gtl.fm.db.dao.DriverDao;
import com.gtl.fm.db.entities.Driver;
import com.gtl.fm.db.exception.RequestedEmailNotAvailableException;

@Repository
public class DriverDaoImpl extends GenericDaoImpl<Driver> implements DriverDao{

	Logger logger = LoggerFactory.getLogger(DriverDaoImpl.class);
	
	@Override
	public List<Driver> getDrivers(Integer start,String sortBy,String serchBy,String serchString) {
		
		List<Driver> affectedDriver = null;
		try {
			boolean activeFlag = true;
			
			if(serchBy == null) {
				if(sortBy == null) {
					affectedDriver = createQuery("from Driver where isActive = :activeFlag",Driver.class)
					         .setParameter("activeFlag", activeFlag)
					         .setFirstResult(start)
					         .setMaxResults(5)
					         .getResultList();
				}else {
					

					String query = String.format("from Driver where isActive = :activeFlag ORDER BY %s asc", sortBy);
					affectedDriver = createQuery(query,Driver.class)
					         .setParameter("activeFlag", activeFlag)
					         .setFirstResult(start)
					         .setMaxResults(5)
					         .getResultList();
				}
			}else {
				String query = "from Driver where isActive = :activeFlag and "+serchBy+" LIKE '%"+serchString+"%' ";
				System.out.println(query);
				affectedDriver = createQuery(query,Driver.class)
		         .setParameter("activeFlag", activeFlag)
		         .setFirstResult(start)
		         .setMaxResults(5)
		         .getResultList();
			}
			
			

		}catch (NoResultException ex) {
			System.out.println("no record found");
			logger.error("Failed to find a drivers!");
		}
		return affectedDriver;
	}
	
	@Override
	public Long getPages() {
		int pageSize = 5;
		boolean activeFlag = true;
		TypedQuery<Long> q = createQuery("select count(*) from Driver where isActive = :activeFlag",Long.class);
		q.setParameter("activeFlag", activeFlag);
		
		Long result = q.getResultList().get(0)/pageSize;
		if(q.getResultList().get(0)%pageSize != 0) {
			result += 1;
		}
		
		return result;
	}

	@Override
	public List<Driver> getDriver(int id) {
		List<Driver> affectedDriver = null;
		try {
			boolean activeFlag = true;
			affectedDriver =  createQuery("from Driver where id = :Id and isActive = :activeFlag",Driver.class)
							  .setParameter("Id", id)			
							  .setParameter("activeFlag", activeFlag)
							  .getResultList();
			
		}
		catch(NoResultException ex) {
			return null;
		}
		return affectedDriver;
	}

	@Override
	public Driver saveDriver(Driver driver) {
		driver.setActive(true);
//		System.out.println(driver.getId());
		if(driver.getId() != null) {
			try {
//				Driver dvr = createQuery("from Driver where email =:Email",Driver.class).setParameter("Email", driver.getEmail()).getSingleResult();
//				System.out.println("i am here 1");
//				if(dvr.getId() != driver.getId()) {
//					System.out.println("i am here 2");
//					throw new RequestedEmailNotAvailableException();
//				}
				
//				Driver dvr = findByEmail(driver.getEmail());
//				if(dvr.getId() != driver.getId()) {
//					throw new RequestedEmailNotAvailableException();
//				}
				update(driver);
				
			}catch (NoResultException e) {}
		}
		else{
			save(driver);
		}
//		System.out.println("i am here 4");
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

	@Override
	public List<Driver> getDriverNames() {
		List<Driver> affectedDriver = null;
		try {
			boolean activeFlag = true;
			affectedDriver = createQuery("select id,firstName,lastName from Driver where isActive = :deleteFlag",Driver.class)
					         .setParameter("deleteFlag", activeFlag)
					         .getResultList();
		}catch (NoResultException ex) {
			logger.error("Failed to find a drivers!");
		}
		return affectedDriver;
	}

	@Override
	public List<Driver> getAllDrivers() {
		List<Driver> affectedDriver = null;
		try {
			boolean activeFlag = true;
			affectedDriver = createQuery("from Driver where isActive = :deleteFlag",Driver.class)
					         .setParameter("deleteFlag", activeFlag)
					         .getResultList();
		}catch (NoResultException ex) {
			logger.error("Failed to find a drivers!");
		}
		return affectedDriver;
	}
	
	
	
}
