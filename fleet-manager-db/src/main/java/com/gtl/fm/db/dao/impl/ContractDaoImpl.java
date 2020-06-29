package com.gtl.fm.db.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gtl.fm.db.dao.ContractDao;
import com.gtl.fm.db.entities.Contract;
import com.gtl.fm.db.entities.Driver;

@Repository
@Transactional
public class ContractDaoImpl extends GenericDaoImpl<Contract> implements ContractDao{

	Logger logger = LoggerFactory.getLogger(DriverDaoImpl.class);
	
	@Override
	public List<Contract> getContracts(Integer start,String sortBy,String serchBy,String serchString,Integer userId) {
		List<Contract> contracts = null;
		try {
			contracts =  createQuery("from Contract where userId=:userId",Contract.class)
						.setParameter("userId",userId)
						.setFirstResult(start)
				        .setMaxResults(5)
						.getResultList();
			if(serchBy == null) {
				if(sortBy == null) {
					contracts = createQuery("from Contract where userId=:userId",Contract.class)
							.setParameter("userId",userId)
							.setFirstResult(start)
					        .setMaxResults(5)
							.getResultList();
				}else {
					

					String query = String.format("from Contract where userId=:userId ORDER BY %s asc", sortBy);
					contracts = createQuery(query,Contract.class)
							 .setParameter("userId",userId)
					         .setFirstResult(start)
					         .setMaxResults(5)
					         .getResultList();
				}
			}else {
				String query = "from Contract where userId=:userId and "+serchBy+" LIKE '%"+serchString+"%' ";
				contracts = createQuery(query,Contract.class)
				 .setParameter("userId",userId)
		         .setFirstResult(start)
		         .setMaxResults(5)
		         .getResultList();
			}
					
		}catch (Exception e) {
			System.out.println("no record found");
			logger.error("Failed to find a contracts!");
		}
		return contracts;
				
	}
	
	@Override
	public Long getPages() {
		int pageSize = 5;
		boolean activeFlag = true;
		TypedQuery<Long> q = createQuery("select count(*) from Contract",Long.class);
		Long result = q.getResultList().get(0)/pageSize;
		if(q.getResultList().get(0)%pageSize != 0) {
			result += 1;
		}
		return result;
	}

	@Override
	public Contract getContractById(int id,Integer userId) {
		Contract affectedContract = null;
		try {
			affectedContract =  createQuery("from Contract where id = :Id and userId=:userId",Contract.class)
					  .setParameter("Id", id)
					  .setParameter("userId", userId)
					  .getSingleResult();
			return affectedContract;
		}
		catch(Exception ex) {
			logger.error("Contract not found with id {}",id);
			return null;
		}
	}

	@Override
	public Contract saveContract(Contract caontact) {
		if(caontact.getId() != null) {
			try {
				update(caontact);
				
			}catch (NoResultException e) {}
		}
		else{
			save(caontact);
		}
//		System.out.println("i am here 4");
		return caontact;
	}

}
