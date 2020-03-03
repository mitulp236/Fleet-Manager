package com.gtl.fm.db.dao.impl;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gtl.fm.db.dao.AuthDao;
import com.gtl.fm.db.entities.User;

@Repository
public class AuthDaoImpl extends GenericDaoImpl<User> implements AuthDao{
	
	Logger logger = LoggerFactory.getLogger(AuthDaoImpl.class);

	@Override
	public User login(String email,String password) {
		User affectedUser;
		try {
			 affectedUser = createQuery("from User where email = :Email and password = :Password", User.class)
							.setParameter("Email", email)
							.setParameter("Password", password)
							.setMaxResults(1)
							.getSingleResult();
			
		}catch (NoResultException ex) {
			logger.error("Failed to get user for {}", email, ex);
			affectedUser = null;
		}
		return affectedUser;
	}
	
}
