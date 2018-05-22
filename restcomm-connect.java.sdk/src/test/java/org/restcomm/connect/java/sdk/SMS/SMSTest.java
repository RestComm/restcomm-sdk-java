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
package org.restcomm.connect.java.sdk.SMS;
import org.restcomm.connect.java.sdk.BasicTest;

import static org.junit.Assert.*;
import org.apache.http.ProtocolException;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.restcomm.connect.java.sdk.SMS.*;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.restcomm.connect.java.sdk.Exceptions.*;
import org.restcomm.connect.java.sdk.Restcomm;

import org.junit.rules.ExpectedException;
import java.io.IOException;

public class SMSTest extends BasicTest{
	
	private String path = "src/test/java/org/restcomm/connect/java/sdk/SMS/TextFiles/";
	private String SMSSid = "SMade2570e7f554578ac590311085f53e2";
	@Rule 
    public WireMockRule wireMockRule = new WireMockRule(8080);
	
	@Test
	public void testGetSMS() throws Exception{ 
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/SMS/Messages.json/"+SMSSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "SMS/json")
				  .withBody(readFile(path+"getSMS.txt"))));
		
		SMS a = SMS.getSMS(SMSSid);
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/SMS/Messages.json/"+SMSSid)));
		assertEquals(200, Restcomm.getStatusCode());
		assertEquals(SMSSid,a.getSid());
	}
	@Test
	public void testnewSMS() throws Exception {
		
		WireMock.stubFor(WireMock.post(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/SMS/Messages.json/"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("From=%2B1654123987"))
				   .withRequestBody(WireMock.containing("To=%2B1321654879"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(path+"getSMS.txt"))));
		
		SMS b = SMS.newSMS().From("+1654123987").To("+1321654879").Body("This is a test from RestComm").sendSMS();
	
		WireMock.verify(WireMock.postRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/SMS/Messages.json/")));
		assertEquals(200, Restcomm.getStatusCode());
		assertEquals("+1654123987",b.getFrom());
		assertEquals("+1321654879",b.getTo());
		
	}
	@Test
	public void testSMSList() throws Exception{
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/SMS/Messages.json"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withQueryParam("From", WireMock.equalTo("Raj"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "SMS/json")
				  .withBody(readFile(path+"getSMSList.txt"))));
		
		SMSList a = SMSList.getFilteredList().From("Raj").Filter();
		
		SMS b = a.get(0);
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/SMS/Messages.json?From=Raj")));
		assertEquals(200,Restcomm.getStatusCode());
		assertNotNull(a);
		assertEquals("Raj",b.getFrom());

	}
}