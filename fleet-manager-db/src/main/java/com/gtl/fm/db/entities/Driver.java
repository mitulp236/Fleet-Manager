package com.gtl.fm.db.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="driver_tbl")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String title;
	@Column
	private String firstName;
	@Column
	private String middleName;
	@Column
	private String lastName;
	@Column
	private Date dob;
	@Column(unique = true)
	private String email;
	@Column
	private String telephone;
	@Column
	private String mobile;
	@Column
	private String jobTitle;
	@Column
	private String staffNumber;
	@Column
	private String address;
	@Column
	private String postcode;
	@Column
	private String city;
	@Column
	private String licenseNo;
	@Column
	private Date licenseValidFrom;
	@Column
	private Date licenseValidTo;
	@Column
	private Date endDate;
	@Column
	private boolean isActive;
	@Column
	private boolean webAccess;
	@Column
	private int catId;
	
	
	
	public boolean isWebAccess() {
		return webAccess;
	}
	public void setWebAccess(boolean webAccess) {
		this.webAccess = webAccess;
	}
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
	
	
}
