package com.gtl.fm.api;

import com.gtl.fm.api.bean.SelfExpiringMap;
import com.gtl.fm.api.dto.response.UserResponseDto;

public class ApiBase {

	
	public static boolean isAuthorized(String auth_token) {
		
		UserResponseDto usr =  SelfExpiringMap.map.get(auth_token);
		if(usr!=null) {
			return true;
		}
		return false;
	}
	
	
	
}
