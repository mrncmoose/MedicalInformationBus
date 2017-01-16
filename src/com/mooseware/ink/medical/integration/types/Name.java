package com.mooseware.ink.medical.integration.types;

import java.util.List;

public class Name {
	private String use;
	private List<String> family;
	private List<String> given;
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public List<String> getFamily() {
		return family;
	}
	public void setFamily(List<String> family) {
		this.family = family;
	}
	public List<String> getGiven() {
		return given;
	}
	public void setGiven(List<String> given) {
		this.given = given;
	}
}
