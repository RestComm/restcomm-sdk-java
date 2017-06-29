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
package org.restcomm.connect.java.sdk.Emails;
import org.restcomm.connect.java.sdk.BasicTest;

import static org.junit.Assert.*;
import org.apache.http.ProtocolException;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.restcomm.connect.java.sdk.Emails.*;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.restcomm.connect.java.sdk.Exceptions.*;
import org.restcomm.connect.java.sdk.Restcomm;

import org.junit.rules.ExpectedException;
import java.io.IOException;

public class EmailTest extends BasicTest{
	
	private String path = "src/test/java/org/restcomm/connect/java/sdk/Emails/TextFiles/";
	private String EmailSid = "SMade2570e7f554578ac590311085f53e2";
	@Rule 
    public WireMockRule wireMockRule = new WireMockRule(8080);
	
	@Test
	public void testnewEmail() throws Exception {
		
		WireMock.stubFor(WireMock.post(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Email/Messages.json/"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("From=m%40hmail.com"))
				   .withRequestBody(WireMock.containing("To=y%40hmail.com"))
				   .withRequestBody(WireMock.containing("Body=This+is+RestComm"))
				   .withRequestBody(WireMock.containing("Subject=Test+Email"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile(path+"getEmail.txt"))));
		
		Email b = Email.newEmail().From("m@hmail.com").To("y@hmail.com").Body("This is RestComm").Subject("Test Email").sendEmail();
	
		WireMock.verify(WireMock.postRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Email/Messages.json/")));
		assertEquals(200, Restcomm.getStatusCode());
		assertEquals("m@hmail.com",b.getFrom());
		assertEquals("y@hmail.com",b.getTo());
		
	}

}