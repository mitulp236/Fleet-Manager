package com.gtl.fm.service;

import java.util.List;

import com.gtl.fm.db.entities.Contract;

public interface ContractService {

	List<Contract> getContracts(Integer start,String sortBy,String serchBy,String serchString,Integer userId);
	
	Long getPages();
	
	Contract getContractById(int id,Integer userId);
	
	Contract saveContract(Contract caontact);
}
