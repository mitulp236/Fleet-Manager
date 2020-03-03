package com.gtl.fm.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gtl.fm.api.dto.UserDto;
import com.gtl.fm.api.dto.response.UserResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.gtl.fm.db.entities.User;
import com.gtl.fm.service.AuthService;

@ComponentScan
@Api(value = "/user", tags = "User")
@RestController
@RequestMapping(value = "/user", produces = { "application/json" })
public class AuthenticateAPI {

	
	@Autowired
    private AuthService authService; 
    
    @CrossOrigin
    @ApiOperation(value = "Authenticate user")
    @RequestMapping(value = "login", method = RequestMethod.POST, consumes = { "application/json" })
    public ResponseEntity<UserResponseDto> login(@RequestBody UserDto usr) {    	
    	User affectedUser = authService.Login(usr.getEmail(),usr.getPassword());
    	UserResponseDto res = new UserResponseDto();
    	if(affectedUser!=null) {
            res.setMessage("Welcome "+usr.getEmail());
            res.setCode(200);
            return ResponseEntity.status(HttpStatus.OK).body(res);
    	}
    	res.setMessage("Username and password not matched ! ");
        res.setCode(401);
        return ResponseEntity.status(401).body(res);
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
}
