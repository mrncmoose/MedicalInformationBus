package com.mooseware.ink.medical.integration.types.medication;

import java.time.ZonedDateTime;
import java.util.List;

import com.mooseware.ink.medical.integration.types.Identifier;

public class Resource extends com.mooseware.ink.medical.integration.types.Resource {

	private ZonedDateTime dateWritten;
	private List<Identifier> identifier;
	private Prescriber prescriber;
	private MedicationReference medicationReference;
	private List<DosageInstruction> dosageInstruction;
	private DispenseRequest dispenseRequest;

	public ZonedDateTime getDateWritten() {
		return dateWritten;
	}
	public void setDateWritten(ZonedDateTime dateWritten) {
		this.dateWritten = dateWritten;
	}
	public List<Identifier> getIdentifier() {
		return identifier;
	}
	public void setIdentifier(List<Identifier> identifier) {
		this.identifier = identifier;
	}
	public Prescriber getPrescriber() {
		return prescriber;
	}
	public void setPrescriber(Prescriber prescriber) {
		this.prescriber = prescriber;
	}
	public MedicationReference getMedicationReference() {
		return medicationReference;
	}
	public void setMedicationReference(MedicationReference medicationReference) {
		this.medicationReference = medicationReference;
	}
	public List<DosageInstruction> getDosageInstruction() {
		return dosageInstruction;
	}
	public void setDosageInstruction(List<DosageInstruction> dosageInstruction) {
		this.dosageInstruction = dosageInstruction;
	}
	public DispenseRequest getDispenseRequest() {
		return dispenseRequest;
	}
	public void setDispenseRequest(DispenseRequest dispenseRequest) {
		this.dispenseRequest = dispenseRequest;
	}
}
