package com.mooseware.ink.medical.integration.fhir.resources;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.mooseware.ink.medical.integration.types.Bundle;
import com.mooseware.ink.medical.integration.types.Entry;
import com.mooseware.ink.medical.integration.types.Resource;

/**
 * Manage patient FHIR resources performing operations such as GET/PUT/POST, etc.
 * @author moose
 *
 */
public class Patient {
	private String emrUrl;
	Logger logg = LoggerFactory.getLogger(Patient.class);
	public Patient(String url) {
		emrUrl = url;
	}
	
	public ArrayList<Resource> getPatientResoruce(String givenName, String familyName)
		throws Exception {
		String fhirPatientResource = "Patient?family=" + familyName + "&given="+givenName;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet getRequest = new HttpGet(emrUrl + fhirPatientResource);
		getRequest.addHeader("accept", "application/json");
		HttpResponse response = httpclient.execute(getRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
			logg.error("Unable to get patient resource with status code: " 
					+ response.getStatusLine().getStatusCode());
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}
		BufferedReader br = new BufferedReader(
				new InputStreamReader((response.getEntity().getContent())));
		Gson gson = new Gson();
		Bundle b = new Bundle();
		b = gson.fromJson(br, Bundle.class);

		List<com.mooseware.ink.medical.integration.types.Entry> entries = b.getEntry();
		Iterator<com.mooseware.ink.medical.integration.types.Entry> entryI = entries.iterator();
		ArrayList<Resource> patientResources = new ArrayList<Resource>();
		while(entryI.hasNext()) {
			Entry e = entryI.next();
			Resource r = e.getResource();
			patientResources.add(r);
		}
		return patientResources;
	}
}
