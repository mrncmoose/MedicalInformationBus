package com.mooseware.ink.medical.integration.fhir.resources;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.mooseware.ink.medical.integration.types.Resource;

public class PatientTest {

	@Test
	public void testGetPatientResoruce() {
		String emrUrl = "https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/";
		Patient patientResource = new Patient(emrUrl);
		try {
			ArrayList<Resource> patients = patientResource.getPatientResoruce("Jason", "Argonaut");
			System.out.println("Got " + patients.size() + " back");
			assertTrue(patients.size()==2);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception caught.");
		}
	}

}
