package com.gtl.fm.api.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.gtl.fm.db.entities.Contract;
import com.gtl.fm.db.entities.Driver;

@XmlRootElement(name = "Contract")
public class ContractDto {


	private Integer id;
	private String vehicaleName;
	private String licensePlate;
	private Integer distance; 
	private Integer duration; 
	private Date startDate;
	private Date endDate;
	private Integer driverId;
	private Long pages;
	private Driver driver;
	
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVehicaleName() {
		return vehicaleName;
	}
	public void setVehicaleName(String vehicaleName) {
		this.vehicaleName = vehicaleName;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getDriverId() {
		return driverId;
	}
	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}
	public Long getPages() {
		return pages;
	}
	public void setPages(Long pages) {
		this.pages = pages;
	}
	
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	@SuppressWarnings("null")
	public static List<ContractDto> transform(List<Contract> entityList) {
		
		List<ContractDto> listOfContracts = new ArrayList<ContractDto>();
		
		
		for (Contract entity : entityList) {
			
			ContractDto dto = new ContractDto();
			dto.setId(entity.getId());
			dto.setDistance(entity.getDistance());
			dto.setDriverId(entity.getDriverId());
			dto.setDuration(entity.getDuration());
			dto.setDistance(entity.getDistance());
			dto.setEndDate(entity.getEndDate());
			dto.setLicensePlate(entity.getLicensePlate());
			dto.setVehicaleName(entity.getVehicaleName());
			dto.setStartDate(entity.getStartDate());
			dto.setDriver(entity.getDriver());
			
			listOfContracts.add(dto);
		}
		return listOfContracts;
	}
	
}
