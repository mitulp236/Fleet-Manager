package com.gtl.fm.api.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.gtl.fm.db.entities.User;


@XmlRootElement(name = "User")
public class UserDto {

	private int id;
	private String name;
    private String email;
    private String password;
    
    
    public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User toEntity() {
		User usr = new User();
		usr.setId(getId());
		usr.setName(getName());
		usr.setEmail(getEmail());
		usr.setPassword(getPassword());
		return usr;
	}
}
