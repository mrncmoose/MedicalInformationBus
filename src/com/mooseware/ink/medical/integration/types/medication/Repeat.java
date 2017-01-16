package com.mooseware.ink.medical.integration.types.medication;

public class Repeat {
	private Integer frequency;
	private Integer period;
	private String periodUnits;
	private BoundsPeriod boundsPeriod;
	
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public String getPeriodUnits() {
		return periodUnits;
	}
	public void setPeriodUnits(String periodUnits) {
		this.periodUnits = periodUnits;
	}
	public BoundsPeriod getBoundsPeriod() {
		return boundsPeriod;
	}
	public void setBoundsPeriod(BoundsPeriod boundsPeriod) {
		this.boundsPeriod = boundsPeriod;
	}
}
