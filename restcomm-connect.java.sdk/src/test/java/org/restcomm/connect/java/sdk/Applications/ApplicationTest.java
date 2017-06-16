/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.restcomm.connect.java.sdk;

import static org.junit.Assert.*;
import org.apache.http.ProtocolException;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.restcomm.connect.java.sdk.Applications.*;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.restcomm.connect.java.sdk.Exceptions.*;
import org.restcomm.connect.java.sdk.Restcomm;

import org.junit.rules.ExpectedException;
import java.io.IOException;

public class ApplicationTest extends BasicTest{
	
	private String path = "src/test/java/org/restcomm/connect/java/sdk/Applications/TextFiles/";
	private String ApplicationSid = "APf74f032ab5d14a8bba4849cb2e2e0db4";
	@Rule 
    public WireMockRule wireMockRule = new WireMockRule(8080);
	
	@Test
	public void testGetApplication() throws Exception{ 
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Applications.json/"+ApplicationSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(path+"GetApplication.txt"))));
		
		Application a = Application.getApplication(ApplicationSid);
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Applications.json/"+ApplicationSid)));
		assertEquals(200, Restcomm.getStatusCode());
		assertEquals(ApplicationSid,a.getSid());
	}
	
	@Test
	public void testAddApplication() throws Exception{
		String RcmlUrlString = "/restcomm-rvd/services/apps/PR2cbed2a2a56947cdbeaa8b0af8a6c02d/controller";
		
		WireMock.stubFor(WireMock.post(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Applications.json/"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("FriendlyName=rvdESDemo"))
				   .withRequestBody(WireMock.containing("Kind=voice"))
				  .withRequestBody(WireMock.containing("RcmlUrl="+RcmlUrlString.replaceAll("/","%2F")))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(path+"GetApplication.txt"))));
		
		Application a = Application.addApplication().FriendlyName("rvdESDemo").RcmlUrl(RcmlUrlString).Kind("voice").add();
		
		
		WireMock.verify(WireMock.postRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Applications.json/")));
		assertEquals(200,Restcomm.getStatusCode());
		assertEquals("rvdESDemo",a.getFriendly_name());
		
	}
	@Test
	public void testaddApplication() throws Exception{
		String RcmlUrlString = "/restcomm-rvd/services/apps/PR2cbed2a2a56947cdbeaa8b0af8a6c02d/controller";
		
		WireMock.stubFor(WireMock.post(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Applications.json/"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("FriendlyName=rvdESDemo"))
				   .withRequestBody(WireMock.containing("Kind=voice"))
				  .withRequestBody(WireMock.containing("RcmlUrl="+RcmlUrlString.replaceAll("/","%2F")))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(path+"GetApplication.txt"))));
		
		Application a = Application.addApplication().FriendlyName("rvdESDemo").RcmlUrl(RcmlUrlString).Kind("voice").add();
		
		
		WireMock.verify(WireMock.postRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Applications.json/")));
		assertEquals(200,Restcomm.getStatusCode());
		assertEquals("rvdESDemo",a.getFriendly_name());
		
	}
	@Test
	public void testUpdateApplication()throws Exception{
		
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Applications.json/"+ApplicationSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(path+"GetApplication.txt"))));
		
		Application a = Application.getApplication(ApplicationSid);
		assertEquals("rvdESDemo",a.getFriendly_name());
		
		WireMock.stubFor(WireMock.put(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Applications.json/"+ApplicationSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("FriendlyName=Martin"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(path+"UpdateApplication.txt"))));
		
		 a = a.updateApplication().newFriendlyName("Martin").update();
		
		
		WireMock.verify(WireMock.putRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Applications.json/"+ApplicationSid)));
		assertEquals(200,Restcomm.getStatusCode());
		assertEquals("Martin",a.getFriendly_name());
		
	}
	//@Test(expected=ResourceNotFoundException.class)
	/*public void testDeleteApplication() throws ProtocolException
	{
		Application.deleteApplication(ApplicationSid);
		
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Applications.json/"+ApplicationSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(404)
				  .withHeader("Content-Type", "application/json")
				  .withBody("Requested resource is not present")));
		
		Application.getApplication(ApplicationSid);
		
	}*/
	@Test
	public void testApplicationList() throws Exception{
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Applications.json/"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(path+"GetApplicationList.txt"))));
		
		ApplicationList a = Application.getApplicationList();
		
		Application b = a.get(0);
		Application c = a.get(1);
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Applications.json/")));
		assertEquals(200,Restcomm.getStatusCode());
		assertNotNull(a);
		assertEquals("Application",b.getFriendly_name());
		assertEquals("DemoApp",c.getFriendly_name());
		
	}

}
