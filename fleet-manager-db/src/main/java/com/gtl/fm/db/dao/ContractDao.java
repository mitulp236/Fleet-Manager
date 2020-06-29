package com.gtl.fm.db.dao;

import java.util.List;

import com.gtl.fm.db.entities.Contract;

public interface ContractDao {
	
	List<Contract> getContracts(Integer start,String sortBy,String serchBy,String serchString,Integer userId);
	
	Long getPages();
	
	Contract getContractById(int id,Integer userId);
	
	Contract saveContract(Contract caontact);
}
