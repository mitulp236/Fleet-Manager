package com.gtl.fm.api.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Param")
public class ParamDto {

	
	private Integer start;
	private String sortBy;
	private String serchBy;
	private String serchString;
	
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getSerchBy() {
		return serchBy;
	}
	public void setSerchBy(String serchBy) {
		this.serchBy = serchBy;
	}
	public String getSerchString() {
		return serchString;
	}
	public void setSerchString(String serchString) {
		this.serchString = serchString;
	}
	
	

	
	
	
	
}
