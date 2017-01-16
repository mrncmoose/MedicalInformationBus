package com.mooseware.ink.medical.integration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import com.google.gson.Gson;
import com.mooseware.ink.medical.integration.fhir.resources.Patient;
import com.mooseware.ink.medical.integration.types.Bundle;
import com.mooseware.ink.medical.integration.types.Entry;
import com.mooseware.ink.medical.integration.types.Name;


public class Bus {

	public static void main(String[] args) {
		 try {
				final Logger logg = LoggerFactory.getLogger(Bus.class);
				if (args.length < 1) {
					System.out.println("Wrong number of arguements.  Use java -jar fhirSample.jar <emr url>");
					System.exit(0);
				}
				String emrUrl = args[0];
				System.out.println("Emr url: " + emrUrl);
				//"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/Patient?family=Argonaut&given=Jason"
//				String patientResource = "Patient?family=Argonaut&given=Jason";
				Patient patientResource = new Patient(emrUrl);
				
				CloseableHttpClient httpclient = HttpClients.createDefault();
				HttpGet getRequest = new HttpGet( emrUrl + patientResource);
				getRequest.addHeader("accept", "application/json");

				HttpResponse response = httpclient.execute(getRequest);

				if (response.getStatusLine().getStatusCode() != 200) {
					logg.error("Unable to retrieve resource with status code: " 
							+ response.getStatusLine().getStatusCode());
					throw new RuntimeException("Failed : HTTP error code : "
					   + response.getStatusLine().getStatusCode());
				}
				BufferedReader br = new BufferedReader(
		                         new InputStreamReader((response.getEntity().getContent())));
				StringBuffer output = new StringBuffer();
				String temp=br.readLine();
				do {
					output.append(temp);
					temp=br.readLine();
				} while(temp != null);
				logg.debug("json returned: " + output.toString());
				System.out.println("json returned: " + output.toString());
				Gson gson = new Gson();
				Bundle b = new Bundle();
				b = gson.fromJson(output.toString(), Bundle.class);
				List<Entry> entries = b.getEntry();
				Iterator<Entry> ei = entries.iterator();
				while(ei.hasNext()) {
					Entry e = ei.next();
					List<Name> names = e.getResource().getName();
					Iterator<Name> nameI = names.iterator();
					while(nameI.hasNext()) {
						Name pName = nameI.next();
						System.out.println("Patient name: " + pName.getGiven().get(0) + " " + 
								pName.getFamily().get(0));
					}
				}
			  } catch (ClientProtocolException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();
			  }

			}

	}

