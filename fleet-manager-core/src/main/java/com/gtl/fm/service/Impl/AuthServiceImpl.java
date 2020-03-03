package com.gtl.fm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gtl.fm.db.dao.AuthDao;
import com.gtl.fm.db.entities.User;
import com.gtl.fm.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private AuthDao authDao;

	@Override
	@Transactional
	public User Login(String email,String password) {
		return this.authDao.login(email,password);
	}

}
