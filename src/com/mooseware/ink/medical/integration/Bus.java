package com.mooseware.ink.medical.integration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mooseware.ink.medical.integration.fhir.resources.Patient;
import com.mooseware.ink.medical.integration.types.Name;
import com.mooseware.ink.medical.integration.types.Resource;

/**
 * 
 * @author Fred T. Dunaway
 * A simple sample of how to get a patient resource from a FHIR server
 * Assumes use of the EPIC test FHIR server where patient Jason Argonaut is loaded.
 */
public class Bus {

	public static void main(String[] args) {
		Logger logg = LoggerFactory.getLogger(Bus.class);
		if (args.length < 1) {
			System.out.println("Wrong number of arguements.  Use java -jar fhirSample.jar <emr url>");
			System.exit(0);
		}
		String emrUrl = args[0];
		System.out.println("Emr url: " + emrUrl);
		//sample EPIC:  https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/
		 try {
				Patient patientResource = new Patient(emrUrl);
				ArrayList<Resource> patientList = patientResource.getPatientResoruce("Jason", "Argonaut");
				Iterator<Resource> i = patientList.iterator();
				Resource patient;
				while(i.hasNext()) {
					patient = i.next();
					List<Name> names = patient.getName();
					Iterator<Name> nameIt = names.iterator();
					while(nameIt.hasNext()) {
						Name pName = nameIt.next();
						System.out.println(pName.getGiven().get(0) + " " + pName.getFamily().get(0) +
								" birth day: " + patient.getBirthDate());
					}
				}	
			  } catch (Exception e) {
				logg.error("Unable to get patients from ERM at: " + emrUrl);
				e.printStackTrace();
			}

	}
}
