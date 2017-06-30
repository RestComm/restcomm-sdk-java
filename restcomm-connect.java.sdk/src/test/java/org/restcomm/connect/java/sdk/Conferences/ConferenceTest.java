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
package org.restcomm.connect.java.sdk.Conferences;
import org.restcomm.connect.java.sdk.BasicTest;

import static org.junit.Assert.*;
import org.apache.http.ProtocolException;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.restcomm.connect.java.sdk.Conferences.*;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.restcomm.connect.java.sdk.Exceptions.*;
import org.restcomm.connect.java.sdk.Restcomm;

import org.junit.rules.ExpectedException;
import java.io.IOException;

public class ConferenceTest extends BasicTest{
	
	private String path = "src/test/java/org/restcomm/connect/java/sdk/Conferences/TextFiles/";
	private String ConferenceSid = "NO70eddcd2f3424aea94c5d7a638298a6a";
	
	@Rule 
    public WireMockRule wireMockRule = new WireMockRule(8080);
	
	/*@Test
	public void testGetConference() throws Exception{ 
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Conferences.json/"+ConferenceSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "Conference/json")
				  .withBody(readFile(path+"getConference.txt"))));
		
		Conference a = Conference.getConference(ConferenceSid);
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Conferences.json/"+ConferenceSid)));
		assertEquals(200, Restcomm.getStatusCode());
		assertEquals(ConferenceSid,a.getSid());
	}*/

/*	@Test
	public void testConferenceList() throws Exception{
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Conferences.json"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withQueryParam("PageSize", WireMock.equalTo("1"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "Conference/json")
				  .withBody(readFile(path+"getConferenceList.txt"))));
		
		ConferenceList a = ConferenceList.getList();
		
		Conference b = a.get(0);
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Conferences.json")));
		assertEquals(200,Restcomm.getStatusCode());
		assertNotNull(a);
		assertEquals("NOa6b821987c1e47b4b91d26783abc205b",b.getSid());

	}*/
}