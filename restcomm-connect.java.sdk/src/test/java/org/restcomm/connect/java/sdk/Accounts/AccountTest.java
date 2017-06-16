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
import org.apache.http.ProtocolException;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.restcomm.connect.java.sdk.Accounts.*;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Accounts.Account;


public class AccountTest extends BasicTest{
	
	private String Path = "src/test/java/org/restcomm/connect/java/sdk/Accounts/TextFiles/";
	
	@Rule 
    public WireMockRule wireMockRule = new WireMockRule(8080);
	
	@Test
	public void testGetAccount()throws Exception { 
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts.json/"+Restcomm.getAuthID()))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(Path+"GetAccount.txt"))));
		
		Account a = Account.getAccount();
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts.json/"+Restcomm.getAuthID())));
		assertNotNull(a);
		assertEquals(200, Restcomm.getStatusCode());
		

    }
	@Test
	public void testUpdateAccount()throws Exception {
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts.json/"+Restcomm.getAuthID()))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(Path+"GetAccount.txt"))));
		
		Account a = Account.getAccount();
		assertEquals("DemoAccount",a.getFriendly_name());
	
		WireMock.stubFor(WireMock.put(WireMock.urlPathMatching("/Accounts.json/"+Restcomm.getAuthID()))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("FriendlyName=Paul"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(Path+"UpdateAccount.txt"))));
		
		a=a.modifyAccountDetails().newFriendlyName("Paul").modify();
		
		WireMock.verify(WireMock.putRequestedFor(WireMock.urlEqualTo("/Accounts.json/"+Restcomm.getAuthID())));
		assertEquals("Paul",a.getFriendly_name());
		
	}
	
	
	
	

	

}
