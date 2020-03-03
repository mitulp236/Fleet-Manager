package com.gtl.fm.db.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_history_tbl")
public class LoginHistory {

	@Id
	@Column
	private Integer id;
	@Column
	private String email;
	@Column
	private Integer userId;
	@Column
	private Date loginTime; 
	@Column
	private Date logoutTime; 
	@Column
	private Date remoteAddress;
	@Column
	private Date userAgent;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	public Date getRemoteAddress() {
		return remoteAddress;
	}
	public void setRemoteAddress(Date remoteAddress) {
		this.remoteAddress = remoteAddress;
	}
	public Date getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(Date userAgent) {
		this.userAgent = userAgent;
	} 
	
	
}
