package com.gtl.fm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gtl.fm.db.dao.DriverWebAccessDao;
import com.gtl.fm.service.DriverWebAccessService;

@Service
public class DriverWebAccessServiceImpl implements DriverWebAccessService{

	
	@Autowired
	private DriverWebAccessDao driverWebAccessDao;
	
	@Override
	@Transactional
	public void setWebAccesss(int id) {
		driverWebAccessDao.setWebAccesss(id);	
	}

	@Override
	@Transactional
	public void denyWebAccesss(int id) {
		driverWebAccessDao.denyWebAccesss(id);
	}

}
