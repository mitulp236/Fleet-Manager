package com.gtl.fm.api;

import javax.servlet.http.HttpServletRequest;

import com.gtl.fm.api.bean.SelfExpiringMap;
import com.gtl.fm.api.dto.response.UserResponseDto;
import com.gtl.fm.api.utils.TokenUtils;

public class ApiBase {

	private static int Authorized_id;
	private static String Authorized_name;
	private static String Authorized_email;
	
	public int getAuthorized_id() {
		return Authorized_id;
	}
	public static void setAuthorized_id(int authorized_id) {
		Authorized_id = authorized_id;
	}
	public String getAuthorized_name() {
		return Authorized_name;
	}
	public static void setAuthorized_name(String authorized_name) {
		Authorized_name = authorized_name;
	}
	public String getAuthorized_email() {
		return Authorized_email;
	}
	public static void setAuthorized_email(String authorized_email) {
		Authorized_email = authorized_email;
	}
	


	public static boolean isAuthorized(HttpServletRequest clientrequest){
		String userAgent = clientrequest.getHeader("User-Agent");
    	String auth_token = clientrequest.getHeader("auth-token");
    	String session_key = clientrequest.getHeader("session_key");
		
		// check if auth_token is empty or null
		if("".equalsIgnoreCase(auth_token)  || "".equalsIgnoreCase(session_key)) {
			return false;
		}

		//get user object of here matching key(auth_token)
		UserResponseDto usr =  SelfExpiringMap.map.get(auth_token);
		//null checker
		if(usr!=null) {
			String shadow_session_key = TokenUtils.generateToken(usr.getEmail(), userAgent, session_key);
			System.out.println(shadow_session_key);
			
			if(TokenUtils.generateMd5(shadow_session_key).equals(auth_token)){
				setAuthorized_id(usr.getId());
				setAuthorized_name(usr.getName());
				setAuthorized_email(usr.getEmail());
				return true;
			}
		}
		return false;
	}
	
	public static Integer getUserId(HttpServletRequest clientrequest) {
    	String auth_token = clientrequest.getHeader("auth-token");
		UserResponseDto usr =  SelfExpiringMap.map.get(auth_token);
		return usr.getId();
	}
	
	
	
}
