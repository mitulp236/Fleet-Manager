package com.gtl.fm.api;

import java.util.List;

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
import com.gtl.fm.api.dto.DriverDto;
import com.gtl.fm.api.dto.response.DriverResponse;
import com.gtl.fm.api.exception.RestException;
import com.gtl.fm.core.exception.DataNotFoundException;
import com.gtl.fm.db.entities.Driver;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@ComponentScan
@Api(value = "/driver", tags = "Driver")
@RestController
@RequestMapping(value = "/driver", produces = { "application/json" })
public class DriverControlAPI {

	
    @ApiOperation(value = "driver g")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {    	
		return "hello";
    }
	
	
	@Autowired
	private DriverService driverService;
	
	//for getting list of active drivers
	@CrossOrigin
    @ApiOperation(value = "driver list")
    @RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<List<Driver>> Driver() {    	
		List<Driver> affectedDrivers = driverService.getDriver();
    	if(affectedDrivers!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(affectedDrivers);
    	}
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
	
	//for getting specific driver by id
	@CrossOrigin
    @ApiOperation(value = "driver list by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
    public DriverDto Driver(@ApiParam ("Driver Id")  @PathVariable int id) throws RestException {    	

		try {
			Driver driver = driverService.getDriver(id);
			return  DriverDto.transform(driver);
		}catch (DataNotFoundException e) {
			throw new RestException(1001, "Driver not found", HttpStatus.NOT_ACCEPTABLE, e);
		}
    }
	
	
	//for save the new driver
	@CrossOrigin
    @ApiOperation(value = "driver save")
    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = { "application/json" },produces = { "application/json" })      
    public ResponseEntity<DriverResponse> Driver(@RequestBody DriverDto driverDto) {
		Driver dvr = driverDto.toEntity();
		Driver affectedDriver = driverService.saveDriver(dvr);
		DriverResponse res = new DriverResponse();
    	if(affectedDriver!=null) {
    		res.setMessage("Driver Successfully Added !");
    		res.setCode(200);
            return ResponseEntity.status(HttpStatus.OK).body(res);
    	}
    	res.setMessage("Please try again !");
		res.setCode(401);
    	return ResponseEntity.status(401).body(res);
    }
	
	//for delete the driver
		@CrossOrigin
	    @ApiOperation(value = "driver delete")
	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { "application/json" })      
	    public ResponseEntity<DriverResponse> deleteDriver(@PathVariable int id) {

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
	    public ResponseEntity<List<Driver>> getDeletedDriver() {    	
			List<Driver> affectedDrivers = driverService.getDeletedDrivers();
	    	if(affectedDrivers!=null) {
	            return ResponseEntity.status(HttpStatus.OK).body(affectedDrivers);
	    	}
	        return ResponseEntity.status(HttpStatus.OK).body(null);
	    }
	
	
	
}
