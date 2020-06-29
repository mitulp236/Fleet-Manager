package com.gtl.fm.db.dao.impl;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gtl.fm.db.dao.DriverWebAccessDao;
import com.gtl.fm.db.entities.Driver;


@Repository
@Transactional
public class DriverWebAccessDaoImpl extends GenericDaoImpl<Driver> implements DriverWebAccessDao{

	@Override
	public void setWebAccesss(int id) {
		try {
			Driver affectedRow = createQuery("from Driver where id =:id",Driver.class)
					.setParameter("id",id)
					.getSingleResult();
			affectedRow.setWebAccess(true);
			update(affectedRow);
		}catch (NoResultException e) {
			
		}
	}

	@Override
	public void denyWebAccesss(int id) {
	
		try {
			Driver affectedRow = createQuery("from Driver where id =:id",Driver.class)
					.setParameter("id",id)
					.getSingleResult();
			affectedRow.setWebAccess(false);
			update(affectedRow);
		}catch (NoResultException e) {
			
		}
		
	}

}
