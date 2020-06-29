package com.gtl.fm.api.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;

import com.gtl.fm.db.entities.Driver;

@XmlRootElement(name = "Driver")
public class DriverDto {
	
	private Integer id;
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dob;
	private String email;
	private String telephone;
	private String mobile;
	private String jobTitle;
	private String staffNumber;
	private String address;
	private String postcode;
	private String city;
	private String licenseNo;
	private Date licenseValidFrom;
	private Date licenseValidTo;
	private Date endDate;
	private boolean isActive;
	private boolean webAccess;
	private int catId;
	private Long pages;
	

	public int getCatId() {
		return catId;
	}



	public void setCatId(int catId) {
		this.catId = catId;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getMiddleName() {
		return middleName;
	}



	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getJobTitle() {
		return jobTitle;
	}



	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}



	public String getStaffNumber() {
		return staffNumber;
	}



	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPostcode() {
		return postcode;
	}



	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getLicenseNo() {
		return licenseNo;
	}



	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}



	public Date getLicenseValidFrom() {
		return licenseValidFrom;
	}



	public void setLicenseValidFrom(Date licenseValidFrom) {
		this.licenseValidFrom = licenseValidFrom;
	}



	public Date getLicenseValidTo() {
		return licenseValidTo;
	}



	public void setLicenseValidTo(Date licenseValidTo) {
		this.licenseValidTo = licenseValidTo;
	}



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isWebAccess() {
		return webAccess;
	}

	public void setWebAccess(boolean webAccess) {
		this.webAccess = webAccess;
	}
	
	public Long getPages() {
		return pages;
	}



	public void setPages(Long pages) {
		this.pages = pages;
	}



	public Driver toEntity() {
		
		Driver driver = new Driver();
		driver.setId(getId());
		driver.setTitle(getTitle());
		driver.setFirstName(getFirstName());
		driver.setMiddleName(getMiddleName());
		driver.setLastName(getLastName());
		driver.setDob(getDob());
		driver.setEmail(getEmail());
		driver.setTelephone(getTelephone());
		driver.setMobile(getMobile());
		driver.setJobTitle(getJobTitle());
		driver.setStaffNumber(getStaffNumber());
		driver.setAddress(getAddress());
		driver.setPostcode(getPostcode());
		driver.setCity(getCity());
		driver.setLicenseNo(getLicenseNo());
		driver.setLicenseValidFrom(getLicenseValidFrom());
		driver.setLicenseValidTo(getLicenseValidTo());
		driver.setEndDate(getEndDate());
		driver.setActive(isActive());
		driver.setWebAccess(isWebAccess());
		driver.setCatId(getCatId());
	
		
		return driver;
	}
	
	@SuppressWarnings("null")
	public static List<DriverDto> transform(List<Driver> entityList) {
		
		List<DriverDto> listOfDrivers = new ArrayList<DriverDto>();
		
		
		for (Driver entity : entityList) {
			
			DriverDto dto = new DriverDto();
			dto.setId(entity.getId());
			dto.setTitle(entity.getTitle());
			dto.setFirstName(entity.getFirstName());
			dto.setMiddleName(entity.getMiddleName());
			dto.setLastName(entity.getLastName());
			dto.setDob(entity.getDob());
			dto.setEmail(entity.getEmail());
			dto.setTelephone(entity.getTelephone());
			dto.setMobile(entity.getMobile());
			dto.setJobTitle(entity.getJobTitle());
			dto.setStaffNumber(entity.getStaffNumber());
			dto.setAddress(entity.getAddress());
			dto.setPostcode(entity.getPostcode());
			dto.setCity(entity.getCity());
			dto.setLicenseNo(entity.getLicenseNo());
			dto.setLicenseValidFrom(entity.getLicenseValidFrom());
			dto.setLicenseValidTo(entity.getLicenseValidTo());
			dto.setEndDate(entity.getEndDate());
			dto.setActive(entity.isActive());
			dto.setWebAccess(entity.isWebAccess());
			dto.setCatId(entity.getCatId());
			
			listOfDrivers.add(dto);
		}
		return listOfDrivers;
	}
	
}
