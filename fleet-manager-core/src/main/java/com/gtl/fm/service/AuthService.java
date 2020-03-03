package com.gtl.fm.service;

import com.gtl.fm.db.entities.User;

public interface AuthService {
	User Login(String email,String password);
}
