package com.gtl.fm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gtl.fm.db.dao.BudgetCatDao;
import com.gtl.fm.db.entities.BudgetCat;
import com.gtl.fm.service.BudgetCatService;

public class BudgetCatServiceImpl implements BudgetCatService{

	@Autowired
	private BudgetCatDao budgetCatDao;
	
	
	@Override
	public List<BudgetCat> getBudgetCat() {
		return budgetCatDao.getBudgetCat();
	}

}
