package com.gtl.fm.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gtl.fm.api.exception.RestException;
import com.gtl.fm.db.entities.BudgetCat;
import com.gtl.fm.service.BudgetCatService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@ComponentScan
@CrossOrigin(origins = "*",exposedHeaders = "*,Access-Control-Expose-Headers" )
@Api(value = "/budgetcat", tags = "BudgetCat")
@RestController
@RequestMapping(value = "/budgetcat", produces = { "application/json" })
public class BudgetCatApi extends ApiBase {

	@Autowired
	public HttpServletRequest clientrequest;
	
	@Autowired
	private BudgetCatService budgetCatService;
	
	@ApiOperation(value = "budgetcat list")
    @RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<List<BudgetCat>> BudgetcatList() 
	{    	
//		if(!isAuthorized(clientrequest)) {
//    		Throwable e = null;
//			throw new RestException(1004, "You are not Authorized ! please login again", HttpStatus.UNAUTHORIZED, e);
//    	}

		List<BudgetCat> budgetCatList = budgetCatService.getBudgetCat();
    	if(budgetCatList!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(budgetCatList);
    	}
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
