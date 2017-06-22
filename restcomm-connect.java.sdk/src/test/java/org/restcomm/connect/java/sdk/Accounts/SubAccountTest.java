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
package org.restcomm.connect.java.sdk.Accounts;
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


public class SubAccountTest extends BasicTest{

	private String Path = "src/test/java/org/restcomm/connect/java/sdk/Accounts/TextFiles/";
	private String SubAccountSid = "AC53444f91e698c0c7caa2dbc3bdbf93fc";
	@Rule 
    public WireMockRule wireMockRule = new WireMockRule(8080);
	
	@Test
	public void testGetSubAccount() throws Exception { 
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts.json/"+SubAccountSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(Path+"GetSubAccount.txt"))));
		
		SubAccount a = SubAccount.getSubAccount(SubAccountSid);
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts.json/"+SubAccountSid)));
		assertEquals(200, Restcomm.getStatusCode());
		assertEquals(SubAccountSid,a.getSid());
    }
	@Test
	public void testUpdateSubAccount() throws Exception {
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts.json/"+SubAccountSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(Path+"GetSubAccount.txt"))));
		
		SubAccount b = SubAccount.getSubAccount(SubAccountSid);
		assertEquals("Test",b.getFriendly_name());
		
		WireMock.stubFor(WireMock.put(WireMock.urlPathMatching("/Accounts.json/"+SubAccountSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("FriendlyName=Lion"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(Path+"UpdateSubAccount.txt"))));
		
		b=b.modifySubAccountDetails().newFriendlyName("Lion").modify();
		
		WireMock.verify(WireMock.putRequestedFor(WireMock.urlEqualTo("/Accounts.json/"+SubAccountSid)));
		assertEquals("Lion",b.getFriendly_name());
		
	}
	@Test
	public void testNewSubAccountCreator() throws Exception{
		WireMock.stubFor(WireMock.post(WireMock.urlPathMatching("/Accounts.json/"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("FriendlyName=Test&Password=123456789abcd&Role=Administrator&EmailAddress=demo%40demo.com"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(Path+"GetSubAccount.txt"))));

		SubAccount b = Account.createSubAccount().FriendlyName("Test").Password("123456789abcd").Role("Administrator").Email("demo@demo.com").create();
		
		WireMock.verify(WireMock.postRequestedFor(WireMock.urlEqualTo("/Accounts.json/")));
		assertEquals(b.getFriendly_name(),"Test");
		assertEquals(b.getRole(),"Administrator");
		assertEquals(b.getEmail_address(),"demo@demo.com");
		//WireMock.verify(WireMock.putRequestedFor(WireMock.urlEqualTo("/Accounts.json/")));
		//assertEquals(b.getFriendly_name(),"Paul");
	}

	@Test
	public void testGetSubAccountList() throws Exception{ 
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts.json/"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(Path+"GetList.txt"))));
		
		SubAccountList a = Account.getSubAccountList();
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts.json/")));
		assertEquals(200, Restcomm.getStatusCode());
		assertNotNull(a);
    }
	
	

}
