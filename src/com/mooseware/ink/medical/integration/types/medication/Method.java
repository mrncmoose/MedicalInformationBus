package com.mooseware.ink.medical.integration.types.medication;

import java.util.List;

public class Method {
	private String text;
	private List<Coding> coding;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Coding> getCoding() {
		return coding;
	}
	public void setCoding(List<Coding> coding) {
		this.coding = coding;
	}
}
