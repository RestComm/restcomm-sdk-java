package org.restcomm.connect.java.sdk;

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
				  .withBody(readFile("GetSResponse.txt"))));
		
		SubAccount a = SubAccount.getSubAccount(SubAccountSid);
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts.json/"+SubAccountSid)));
		assertEquals(200, Restcomm.getStatusCode());
		assertEquals(SubAccountSid,a.getSid());
    }
	

}
