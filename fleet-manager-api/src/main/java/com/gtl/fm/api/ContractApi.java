package com.gtl.fm.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gtl.fm.api.dto.ContractDto;
import com.gtl.fm.api.dto.DriverDto;
import com.gtl.fm.api.dto.ParamDto;
import com.gtl.fm.api.dto.response.DriverResponse;
import com.gtl.fm.api.exception.RestException;
import com.gtl.fm.core.exception.DataNotFoundException;
import com.gtl.fm.core.exception.EmailAlreadyUsedException;
import com.gtl.fm.core.exception.ValidationException;
import com.gtl.fm.db.entities.Contract;
import com.gtl.fm.db.entities.Driver;
import com.gtl.fm.service.ContractService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Mitul
 *
 */
@ComponentScan
@Api(value = "/contract", tags = "User")
@CrossOrigin(origins = "*",exposedHeaders = "*,Access-Control-Expose-Headers" )
@RestController
@RequestMapping(value = "/contract", produces = { "application/json" })
public class ContractApi extends ApiBase{
	
		@Autowired
		public HttpServletRequest clientrequest;
		
		@Autowired
		private ContractService contractService; 

	 	@ApiOperation(value = "")	 	
	    @CrossOrigin
	    @RequestMapping(value = "", method = RequestMethod.POST, produces = { "application/json" })
	    public List<ContractDto> contracts(@RequestBody ParamDto params) {
	 		
			if(!isAuthorized(clientrequest)) {
    			Throwable e = null;
				throw new RestException(1004, "You are not Authorized ! please login again", HttpStatus.UNAUTHORIZED, e);
    		}
			
			Integer userId = getUserId(clientrequest);
	 		
			Integer start = 0;
			String sortBy = params.getSortBy();
			String serchBy = null;
			String serchString = params.getSerchString();
			
			if(params.getSerchBy() != null) {
				serchBy =  params.getSerchBy();
			}
			
			if(params.getStart()!= null) {
				start = params.getStart();
			}
			
	 		List<Contract> contracts = contractService.getContracts(start,sortBy,serchBy,serchString,userId);
	 		
	 		if(contracts.size() != 0){
	 			Long pages = contractService.getPages();
	 			List<ContractDto> dto = ContractDto.transform(contracts);
	 			dto.get(0).setPages(pages);
	 			return dto;
	 		}else{
	 			Throwable e = null;
				throw new RestException(1001, "Contracts not found", HttpStatus.NOT_ACCEPTABLE, e);
			}
	    }
	 	
	 	
	 	@CrossOrigin
	    @ApiOperation(value = "driver list by id")
	    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
	    public Contract getContractById(@ApiParam ("Contract Id")  @PathVariable int id) throws RestException 
		{    	
			if(!isAuthorized(clientrequest)) {
	    		Throwable e = null;
				throw new RestException(1004, "You are not Authorized ! please login again", HttpStatus.UNAUTHORIZED, e);
	    	}
			Integer userId = getUserId(clientrequest);
			try {
				Contract contract = contractService.getContractById(id,userId);
//				return  DriverDto.transform(driver);
				return contract;
			}catch (DataNotFoundException e) {
				throw new RestException(1001, "Contract not found", HttpStatus.NOT_ACCEPTABLE, e);
			}
	    }
	 	
	 	@CrossOrigin
	    @ApiOperation(value = "driver save")
	    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = { "application/json" },produces = { "application/json" })      
	    public ResponseEntity<Contract> SaveContract(@RequestBody Contract contract) 
		{
			if(!isAuthorized(clientrequest)) {
	    		Throwable e = null;
				throw new RestException(1004, "You are not Authorized ! please login again", HttpStatus.UNAUTHORIZED, e);
	    	}
			
			try {
				
				Contract affectedContract = contractService.saveContract(contract);
		    	if(affectedContract!=null) {
		            return ResponseEntity.status(HttpStatus.OK).body(affectedContract);
		    	}
				return ResponseEntity.status(401).body(null);
			}
			catch (ValidationException e) {
				throw new RestException(e.getCode(), e.getMessage(), HttpStatus.NOT_ACCEPTABLE, e);
			}	
	    }

}
