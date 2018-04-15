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
	private String ConferenceSid = "CF00a13f9e9ed741e99ff460e86ff5c67a";
	private String ParticipantSid = "CA1d9cc1b36ab4408db8a9b7f7a5a54bdb";
	
	@Rule 
    public WireMockRule wireMockRule = new WireMockRule(8080);
	
	@Test
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
	}
	@Test
	public void testConferenceList() throws Exception{
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Conferences.json"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "Conference/json")
				  .withBody(readFile(path+"getConferenceList.txt"))));
		
		ConferenceList a = ConferenceList.getList();
		
		Conference b = a.get(0);
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Conferences.json")));
		assertEquals(200,Restcomm.getStatusCode());
		assertNotNull(a);
		assertEquals("CF00a13f9e9ed741e99ff460e86ff5c67a",b.getSid());

	}
	@Test
	public void testParticipant() throws Exception{
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Conferences.json/"+ConferenceSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "Conference/json")
				  .withBody(readFile(path+"getConference.txt"))));
		
		Conference a = Conference.getConference(ConferenceSid);
		
		assertEquals(200, Restcomm.getStatusCode());
		
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Conferences/"+ConferenceSid+"/Participants/"+ParticipantSid+".json"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "Conference/json")
				  .withBody(readFile(path+"getParticipant.txt"))));
		
		
		Participant p = a.getParticipant(ParticipantSid);	
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Conferences/"+ConferenceSid+"/Participants/"+ParticipantSid+".json")));
		assertEquals(200,Restcomm.getStatusCode());
		assertEquals("CA1d9cc1b36ab4408db8a9b7f7a5a54bdb",p.getSid());
	}
	@Test
	public void testParticipantList() throws Exception{
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Conferences.json/"+ConferenceSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "Conference/json")
				  .withBody(readFile(path+"getConference.txt"))));
		
		Conference a = Conference.getConference(ConferenceSid);
		
		assertEquals(200, Restcomm.getStatusCode());
		
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Conferences/"+ConferenceSid+"/Participants.json"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "Conference/json")
				  .withBody(readFile(path+"getParticipantList.txt"))));
		
		
		ParticipantList p = a.getParticipantList();	
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Conferences/"+ConferenceSid+"/Participants.json")));
		assertEquals(200,Restcomm.getStatusCode());
		assertEquals("CA1d9cc1b36ab4408db8a9b7f7a5a54bdb",p.get(0).getSid());
	}
}