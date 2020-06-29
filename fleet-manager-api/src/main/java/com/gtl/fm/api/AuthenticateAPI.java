package com.gtl.fm.api;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gtl.fm.api.bean.SelfExpiringMap;
import com.gtl.fm.api.dto.UserDto;
import com.gtl.fm.api.dto.response.UserResponseDto;
import com.gtl.fm.api.exception.RestException;
import com.gtl.fm.api.utils.TokenUtils;
import com.gtl.fm.core.exception.UnAuthorisedException;
import com.gtl.fm.db.entities.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.gtl.fm.service.AuthService;

@CrossOrigin(origins = "*",exposedHeaders = "*,Access-Control-Expose-Headers" )
@ComponentScan
@Api(value = "/user", tags = "User")
@RestController
@RequestMapping(value = "/user", produces = { "application/json" })
public class AuthenticateAPI extends ApiBase {

	
	@Autowired
    private AuthService authService;
	
	@Autowired
	public HttpServletRequest clientrequest;
	
//    @CrossOrigin
    @ApiOperation(value = "Authenticate user")
    @CrossOrigin
    @RequestMapping(value = "login", method = RequestMethod.POST, consumes = { "application/json" })
    public ResponseEntity<UserResponseDto> login(@RequestBody UserDto usr) {
    	try {
    		User user = authService.Login(usr.getEmail(),usr.getPassword());
    		String randomString = TokenUtils.generateRandomString();
    		String userAgent = clientrequest.getHeader("User-Agent");
    		String token = TokenUtils.generateToken(usr.getEmail(), userAgent,randomString);
    		String x_auth_token = TokenUtils.generateMd5(token);
    		
    		UserResponseDto res = new UserResponseDto();
    		res.setId(user.getId());
    		res.setName(user.getName());
    		res.setEmail(user.getEmail());
    		
    		// Put auth-token into SelfExpiringMap 
    		SelfExpiringMap.map.put(x_auth_token, res);
    		
    		HttpHeaders header = new HttpHeaders();
    		header.set("auth-token",x_auth_token);
    		header.set("session_key",randomString);
    		return ResponseEntity.status(HttpStatus.OK).headers(header).body(res);
            
    	}catch(UnAuthorisedException e) {
    		throw new RestException(e.getCode(), e.getMessage(), HttpStatus.UNAUTHORIZED, e);
    	}
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
}
