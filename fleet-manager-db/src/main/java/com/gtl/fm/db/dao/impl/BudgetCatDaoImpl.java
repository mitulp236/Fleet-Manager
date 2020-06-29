package com.gtl.fm.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gtl.fm.db.dao.BudgetCatDao;
import com.gtl.fm.db.entities.BudgetCat;

/**
 * @author Mitul
 *
 */
@Repository
@Transactional
public class BudgetCatDaoImpl extends GenericDaoImpl<BudgetCat> implements BudgetCatDao{

	@Override
	public List<BudgetCat> getBudgetCat() {
		return createQuery("from BudgetCat",BudgetCat.class).getResultList();
	}

}
