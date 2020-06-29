package com.gtl.fm.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
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
import com.gtl.fm.service.DriverService;
import com.gtl.fm.service.DriverWebAccessService;
import com.gtl.fm.api.dto.ContractDto;
import com.gtl.fm.api.dto.DriverDto;
import com.gtl.fm.api.dto.DriverNameDto;
import com.gtl.fm.api.dto.ParamDto;
import com.gtl.fm.api.dto.response.DriverResponse;

import com.gtl.fm.api.exception.RestException;
import com.gtl.fm.core.exception.DataNotFoundException;
import com.gtl.fm.core.exception.EmailAlreadyUsedException;
import com.gtl.fm.core.exception.ValidationException;
import com.gtl.fm.db.entities.Driver;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@ComponentScan
@CrossOrigin(origins = "*",exposedHeaders = "*,Access-Control-Expose-Headers" )
@Api(value = "/driver", tags = "Driver")
@RestController
@RequestMapping(value = "/driver", produces = { "application/json" })
public class DriverControlAPI extends ApiBase{
	
	@Autowired
	public HttpServletRequest clientrequest;

    @ApiOperation(value = "driver g")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {	
    	if(!isAuthorized(clientrequest)) {
    		Throwable e = null;
			throw new RestException(1004, "You are not Authorized ! please login again", HttpStatus.UNAUTHORIZED, e);
    	}
		return "hello world";
    }
	
	
	@Autowired
	private DriverService driverService;
	
	//for getting list of active drivers
	@CrossOrigin
    @ApiOperation(value = "driver list")
    @RequestMapping(value = "", method = RequestMethod.POST, produces = { "application/json" })
    public ResponseEntity<List<DriverDto>> getDrivers( @RequestBody ParamDto params) 
	{    	
		
//		if(!isAuthorized(clientrequest)) {
//    		Throwable e = null;
//			throw new RestException(1004, "You are not Authorized ! please login again", HttpStatus.UNAUTHORIZED, e);
//    	}
		
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
		
		List<Driver> affectedDrivers = driverService.getDrivers(start,sortBy,serchBy,serchString);
		
    	if(affectedDrivers.size() != 0){
    		Long pages = driverService.getPages();
    		List<DriverDto> d =  DriverDto.transform(affectedDrivers);
    		d.get(0).setPages(pages);
            return ResponseEntity.status(HttpStatus.OK).body(d);
    	}else{
    		Throwable e = null;
			throw new RestException(1001, "data not found", HttpStatus.NOT_ACCEPTABLE, e);
    	}
//        return ResponseEntity.status(HttpStatus.OK).body(null);
        
    }
	
	//for getting specific driver by id
	@CrossOrigin
    @ApiOperation(value = "driver list by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
    public List<DriverDto> Driver(@ApiParam ("Driver Id")  @PathVariable int id) throws RestException 
	{    	
//		if(!isAuthorized(clientrequest)) {
//    		Throwable e = null;
//			throw new RestException(1004, "You are not Authorized ! please login again", HttpStatus.UNAUTHORIZED, e);
//    	}
		try {
			List<Driver> driver = driverService.getDriver(id);
			return  DriverDto.transform(driver);
		}catch (DataNotFoundException e) {
			throw new RestException(1001, "Driver not found", HttpStatus.NOT_ACCEPTABLE, e);
		}
    }
	
	
	//for save the new driver
	@CrossOrigin
    @ApiOperation(value = "driver save")
    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = { "application/json" },produces = { "application/json" })      
    public ResponseEntity<Driver> Driver(@RequestBody DriverDto driverDto) 
	{
//		if(!isAuthorized(clientrequest)) {
//    		Throwable e = null;
//			throw new RestException(1004, "You are not Authorized ! please login again", HttpStatus.UNAUTHORIZED, e);
//    	}
		
		Driver dvr = driverDto.toEntity();
		
		
		try {
			if(dvr.getId() == null) {
				 driverService.findByEmail(dvr.getEmail());
			}
			Driver affectedDriver = driverService.saveDriver(dvr);
			DriverResponse res = new DriverResponse();
	    	if(affectedDriver!=null) {
	            return ResponseEntity.status(HttpStatus.OK).body(affectedDriver);
	    	}
	    	res.setMessage("Driver not Added ! please try again");
			res.setCode(1007);
			return ResponseEntity.status(401).body(null);
		}
		catch (EmailAlreadyUsedException e) {
			throw new RestException(1006, e.getMessage(), HttpStatus.NOT_ACCEPTABLE, e);
		}
		catch (ValidationException e) {
			throw new RestException(e.getCode(), e.getMessage(), HttpStatus.NOT_ACCEPTABLE, e);
		}	
    }
	
		//for delete the driver
		@CrossOrigin
	    @ApiOperation(value = "driver delete")
	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { "application/json" })      
	    public ResponseEntity<DriverResponse> deleteDriver(@PathVariable int id) {
				
//			if(!isAuthorized(clientrequest)) {
//	    		Throwable e = null;
//				throw new RestException(1004, "You are not Authorized ! please login again", HttpStatus.UNAUTHORIZED, e);
//	    	}
			
			Driver affectedDriver = driverService.deleteDriver(id);
			DriverResponse res = new DriverResponse();
	    	if(affectedDriver!=null) {
	    		res.setMessage("Driver Successfully Deleted !");
	    		res.setCode(200);
	            return ResponseEntity.status(HttpStatus.OK).body(res);
	    	}
	    	res.setMessage("Something was wrong ! Please try again !");
			res.setCode(401);
	    	return ResponseEntity.status(401).body(res);
	    }
	
		//for getting Deleted Driver list 
		@CrossOrigin
	    @ApiOperation(value = "driver list")
	    @RequestMapping(value = "/inactive", method = RequestMethod.GET, produces = { "application/json" })
	    public ResponseEntity<List<Driver>> getDeletedDriver() 
		{    	
//			if(!isAuthorized(clientrequest)) {
//	    		Throwable e = null;
//				throw new RestException(1004, "You are not Authorized ! please login again", HttpStatus.UNAUTHORIZED, e);
//	    	}
			
			List<Driver> affectedDrivers = driverService.getDeletedDrivers();
	    	if(affectedDrivers!=null) {
	            return ResponseEntity.status(HttpStatus.OK).body(affectedDrivers);
	    	}
	        return ResponseEntity.status(HttpStatus.OK).body(null);
	    }
		
		@Autowired
		private DriverWebAccessService driverWebAccessService;
		
		//for set web access to  specific driver by id
		@CrossOrigin
	    @ApiOperation(value = "driver list by id")
	    @RequestMapping(value = "/setWebAccess/{id}", method = RequestMethod.GET, produces = { "application/json" })
	    public void setDriverWebAccess(@ApiParam ("Driver Id")  @PathVariable int id) throws RestException 
		{    	
//			if(!isAuthorized(clientrequest)) {
//	    		Throwable e = null;
//				throw new RestException(1004, "You are not Authorized ! please login again", HttpStatus.UNAUTHORIZED, e);
//	    	}
			try {
				driverWebAccessService.setWebAccesss(id);
			}catch (DataNotFoundException e) {
				throw new RestException(1001, "Driver not found", HttpStatus.NOT_ACCEPTABLE, e);
			}
	    }
		
		
		//for set web access to  specific driver by id
		@CrossOrigin
	    @ApiOperation(value = "driver list by id")
	    @RequestMapping(value = "/denyWebAccess/{id}", method = RequestMethod.GET, produces = { "application/json" })
	    public void denyDriverWebAccess(@ApiParam ("Driver Id")  @PathVariable int id) throws RestException 
		{    	
//					if(!isAuthorized(clientrequest)) {
//			    		Throwable e = null;
//						throw new RestException(1004, "You are not Authorized ! please login again", HttpStatus.UNAUTHORIZED, e);
//			    	}
			try {
				driverWebAccessService.denyWebAccesss(id);
			}catch (DataNotFoundException e) {
				throw new RestException(1001, "Driver not found", HttpStatus.NOT_ACCEPTABLE, e);
			}
	    }
		
		
		@CrossOrigin
	    @ApiOperation(value = "driver names")
	    @RequestMapping(value = "/driverNames", method = RequestMethod.GET, produces = { "application/json" })
	    public ResponseEntity<List<DriverNameDto>> getAllDrivers() 
		{    	
			
//			if(!isAuthorized(clientrequest)) {
//	    		Throwable e = null;
//				throw new RestException(1004, "You are not Authorized ! please login again", HttpStatus.UNAUTHORIZED, e);
//	    	}
				
			List<Driver> affectedDrivers = driverService.getAllDrivers();
	    	if(affectedDrivers!=null) {
	    		List<DriverNameDto> result = DriverNameDto.transform(affectedDrivers);
	            return ResponseEntity.status(HttpStatus.OK).body(result);
	    	}
	        return ResponseEntity.status(HttpStatus.OK).body(null);
	    }
		
	
		
}
