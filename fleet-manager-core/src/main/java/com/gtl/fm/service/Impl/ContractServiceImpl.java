package com.gtl.fm.service.Impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gtl.fm.core.exception.DataNotFoundException;
import com.gtl.fm.core.exception.ValidationException;
import com.gtl.fm.db.dao.ContractDao;
import com.gtl.fm.db.entities.Contract;
import com.gtl.fm.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService{

	@Autowired
	private ContractDao contractDao;
	
	@Override
	@Transactional
	public List<Contract> getContracts(Integer start,String sortBy,String serchBy,String serchString,Integer userId) {
		List<Contract> contracts =  this.contractDao.getContracts(start,sortBy,serchBy,serchString,userId);
		if(contracts != null) {
			return contracts;
		}
		throw new DataNotFoundException("Contracts Not Found! ");
	}
	
	@Override
	@Transactional
	public Long getPages() {		
		return this.contractDao.getPages();
	}

	@Override
	@Transactional
	public Contract getContractById(int id,Integer userId) {
		Contract contract = this.contractDao.getContractById(id,userId);
		if(contract != null) {
			return contract;
		}
		throw new DataNotFoundException("Contract with id "+id+"is not found ! ");
	}

	@Override
	@Transactional
	public Contract saveContract(Contract caontact) {
		if(caontact.getVehicaleName() == null) {throw new ValidationException("VehicaleName is empty",1008);}
		if(caontact.getDistance() == null) {throw new ValidationException("Distance is empty",1008);}
		if(caontact.getDriverId() == null) {throw new ValidationException("DriverId is empty",1008);}
		if(caontact.getDuration() == null) {throw new ValidationException("Duration is empty",1008);}
		if(caontact.getEndDate() == null) {throw new ValidationException("EndDate is empty",1008);}
		if(caontact.getLicensePlate() == null) {throw new ValidationException("LicensePlate is empty",1008);}
		if(caontact.getStartDate() == null) {throw new ValidationException("StartDate is empty",1008);}
		
		return this.contractDao.saveContract(caontact);
	}
	

}
