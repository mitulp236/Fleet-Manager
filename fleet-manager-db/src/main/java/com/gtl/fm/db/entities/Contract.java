package com.gtl.fm.db.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Mitul
 *
 */
@Entity
@Table(name="contract_tbl")
public class Contract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String vehicaleName;
	@Column
	private String licensePlate;
	@Column
	private Integer distance; // in km
	@Column
	private Integer duration; // in month
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private Integer driverId;
	@Column
	private Integer userId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="driverId", referencedColumnName = "id", insertable = false,updatable = false)
	private Driver driver;
	
	public Driver getDriver() {
		return driver;
	}

	public Integer getDriverId() {
		return driverId;
	}
	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
}
