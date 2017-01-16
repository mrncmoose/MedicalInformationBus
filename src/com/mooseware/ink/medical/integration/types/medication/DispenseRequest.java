package com.mooseware.ink.medical.integration.types.medication;

public class DispenseRequest {
	private ValidityPeriod validityPeriod;

	public ValidityPeriod getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(ValidityPeriod validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
}
