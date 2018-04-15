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
package org.restcomm.connect.java.sdk.AvailablePhoneNumbers;
import org.restcomm.connect.java.sdk.BasicTest;

import static org.junit.Assert.*;
import org.apache.http.ProtocolException;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.restcomm.connect.java.sdk.AvailablePhoneNumbers.*;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.restcomm.connect.java.sdk.Exceptions.*;
import org.restcomm.connect.java.sdk.Restcomm;

import org.junit.rules.ExpectedException;
import java.io.IOException;

public class AvailablePhoneNumberListTest extends BasicTest{
	
	private String path = "src/test/java/org/restcomm/connect/java/sdk/AvailablePhoneNumbers/TextFiles/";
	private String Number= "12034869059";
	@Rule 
    public WireMockRule wireMockRule = new WireMockRule(8080);
	
	@Test
	public void testGetLocalList() throws Exception{ 
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/AvailablePhoneNumbers/US/Local.json"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "Application/json")
				  .withBody(readFile(path+"getLocalList.txt"))));
		
		AvailablePhoneNumberList List = AvailablePhoneNumberList.getList("US","Local");
		
		PhoneNumber a = List.get(0);
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/AvailablePhoneNumbers/US/Local.json")));
		assertEquals(200, Restcomm.getStatusCode());
		assertEquals(Number,a.getPhone_number());
	}
}
