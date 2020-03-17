package com.gtl.fm.api.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TokenUtils {
	
	//generate token
	public static String generateToken(String email,String userAgent,String randomString) {
		String seprator = "#";
		return email + seprator + randomString + seprator + userAgent;
	}
	
	public static String generateRandomString() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz"; 
		StringBuilder sb = new StringBuilder(15);
		for(int i=0;i<15;i++) {
			int index = (int)(AlphaNumericString.length()*Math.random());
			sb.append(AlphaNumericString .charAt(index)); 
		}
		return sb.toString();
	}
	
	//generate MD5 Hash
	public static String generateMd5(String token) {
		try { 
	        MessageDigest md = MessageDigest.getInstance("MD5"); 
	        byte[] messageDigest = md.digest(token.getBytes()); 
	        BigInteger no = new BigInteger(1, messageDigest); 
	        // Convert message digest into hex value 
	        String hashtext = no.toString(16); 
	        while (hashtext.length() < 32) { 
	            hashtext = "0" + hashtext; 
	        } 
	        return hashtext;
	    }  
	    // For specifying wrong message digest algorithms 
	    catch (NoSuchAlgorithmException e) { 
	        throw new RuntimeException(e); 
	    } 
	}
}
