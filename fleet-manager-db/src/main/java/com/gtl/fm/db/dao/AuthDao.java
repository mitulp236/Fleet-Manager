package com.gtl.fm.db.dao;

import com.gtl.fm.db.entities.User;

public interface AuthDao {
	// work remain 
	User login(String  email,String password);
}
