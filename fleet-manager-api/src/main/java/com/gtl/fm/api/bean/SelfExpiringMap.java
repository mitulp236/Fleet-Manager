package com.gtl.fm.api.bean;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.gtl.fm.api.dto.response.UserResponseDto;

import net.jodah.expiringmap.ExpiringMap;

public class SelfExpiringMap {
	
	public static Map<String, UserResponseDto> map = ExpiringMap.builder()
									  .expiration(30, TimeUnit.MINUTES)
									  .build();
}
