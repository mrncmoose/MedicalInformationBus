package com.mooseware.ink.medical.integration.types;


import java.time.LocalDate;
import java.util.List;

public class Resource {
	private String resourceType;
	private String birthDate;
	private Boolean active;
	private String gender;
	private String id;
	private String issue;
	private List<CareProvider> careProvider;
	private List<Name> name;
	private List<Address> address;
	
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	
	public LocalDate getBirthDateAsLocalDate() {
		LocalDate bDate = LocalDate.parse(this.birthDate);
		return bDate;
	}
		
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<CareProvider> getCareProvider() {
		return careProvider;
	}
	public void setCareProvider(List<CareProvider> careProvider) {
		this.careProvider = careProvider;
	}
	public List<Name> getName() {
		return name;
	}
	public void setName(List<Name> name) {
		this.name = name;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
}
