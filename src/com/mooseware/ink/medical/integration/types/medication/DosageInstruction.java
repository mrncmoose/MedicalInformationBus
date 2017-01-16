package com.mooseware.ink.medical.integration.types.medication;

public class DosageInstruction {
	private String text;
	private Boolean asNeededBoolean;
	private Route route;
	private Method method;
	private Timing timing;
	private DoseQuantity doseQuantity;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Boolean getAsNeededBoolean() {
		return asNeededBoolean;
	}
	public void setAsNeededBoolean(Boolean asNeededBoolean) {
		this.asNeededBoolean = asNeededBoolean;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Timing getTiming() {
		return timing;
	}
	public void setTiming(Timing timing) {
		this.timing = timing;
	}
	public DoseQuantity getDoseQuantity() {
		return doseQuantity;
	}
	public void setDoseQuantity(DoseQuantity doseQuantity) {
		this.doseQuantity = doseQuantity;
	}
	
}
