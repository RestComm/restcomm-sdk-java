package org.restcomm.connect.java.sdk;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import org.junit.Rule;

import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restcomm.connect.java.sdk.Accounts.*;



public class SubAccountCreatorTest extends BasicTest{
	
	private SubAccount b;
	
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8080);
	
	@Test
	public void testNewSubAccountCreator() throws IOException, JAXBException {
		WireMock.stubFor(WireMock.post(WireMock.urlPathMatching("/Accounts.json/"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("FriendlyName=DemoAccount&Password=123456789abcd&Role=Administrator&EmailAddress=demoaccount%40restcomm.com"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile("NAccount.txt"))));

		b = Account.createSubAccount().FriendlyName("DemoAccount").Password("123456789abcd").Role("Administrator").Email("demoaccount@restcomm.com").create();
		
		WireMock.verify(WireMock.postRequestedFor(WireMock.urlEqualTo("/Accounts.json/")));
		assertEquals(b.getFriendly_name(),"DemoAccount");
		assertEquals(b.getRole(),"Administrator");
		assertEquals(b.getEmail_address(),"demoaccount@restcomm.com");
		
		
		
		//WireMock.verify(WireMock.putRequestedFor(WireMock.urlEqualTo("/Accounts.json/")));
		//assertEquals(b.getFriendly_name(),"Paul");
		
	}
	@After
	public void afterTest()
	{
		b = null;
	}
}