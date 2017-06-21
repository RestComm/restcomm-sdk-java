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

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.restcomm.connect.java.sdk.Calls.*;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.restcomm.connect.java.sdk.Exceptions.*;
import org.restcomm.connect.java.sdk.Restcomm;

import org.junit.rules.ExpectedException;
import java.io.IOException;

public class CallTest extends BasicTest{
	
	private String path = "src/test/java/org/restcomm/connect/java/sdk/Calls/TextFiles/";
	private String CallSid = "CA55b51d74d3b749628e2e1fc650852992";
	@Rule 
    public WireMockRule wireMockRule = new WireMockRule(8080);
	
	@Test
	public void testGetCall() throws Exception{ 
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Calls.json/"+CallSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(path+"getCall.txt"))));
		
		Call a = Call.getCall(CallSid);
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Calls.json/"+CallSid)));
		assertEquals(200, Restcomm.getStatusCode());
		assertEquals(CallSid,a.getSid());
	}
	@Test
	public void testCreateCall() throws Exception {
		String url ="/cloud/restcomm/xml";
		
		WireMock.stubFor(WireMock.post(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Calls.json/"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("From=AmitBhayani"))
				   .withRequestBody(WireMock.containing("To=nukles1.07"))
				  .withRequestBody(WireMock.containing("Url="+url.replace("/","%2F")))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(path+"getCall.txt"))));
		
		Call b = Call.newCall().From("AmitBhayani").To("nukles1.07").Url(url).makeCall();
	
		WireMock.verify(WireMock.postRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Calls.json/")));
		assertEquals(200, Restcomm.getStatusCode());
		assertEquals("AmitBhayani",b.getFrom());
		assertEquals("nukles1.07",b.getTo());
		
	}
	@Test
	public void testModifyLiveCall() throws Exception{
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Calls.json/"+CallSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(path+"getCall.txt"))));
		
		Call a = Call.getCall(CallSid);
		
		assertEquals(CallSid,a.getSid());
		
		WireMock.stubFor(WireMock.post(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Calls.json/"+CallSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("Status=Completed"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(path+"getUCall.txt"))));
		
		 a = a.modifyLiveCall().newStatus("Completed").modify();
		
		
		WireMock.verify(WireMock.postRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Calls.json/"+CallSid)));
		assertEquals(200,Restcomm.getStatusCode());
		assertEquals("COMPLETED",a.getStatus());
	}
	/* Need to add test for CallsList*/
	@Test
	public void testGetCallList() throws Exception{
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Calls.json/"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(path+"getCallList.txt"))));
		
		CallsList a = CallsList.getCallsList();
		
		Call b = a.get(0);

		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Calls.json/")));
		assertEquals(200,Restcomm.getStatusCode());
		assertNotNull(a);
		assertEquals("mithileshkarnati",b.getTo());
	}
}