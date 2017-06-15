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



public class AccountUpdaterTest extends BasicTest{
	
	private Account b;
	
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8080);
	
	@Before
	public void beforeTest() throws IOException, JAXBException
	{
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts.json/"+Restcomm.getAuthID()))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile("GetResponse.txt"))));
		
		b = Account.getAccount();
		
	}
	@Test
	public void testFriendlyNameUpdate() throws IOException, JAXBException {
		WireMock.stubFor(WireMock.put(WireMock.urlPathMatching("/Accounts.json/"+Restcomm.getAuthID()))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("FriendlyName=Paul"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile("Fupdate.txt"))));
		
		
		
		b=b.modifyAccountDetails().newFriendlyName("Paul").modify();
		
		WireMock.verify(WireMock.putRequestedFor(WireMock.urlEqualTo("/Accounts.json/"+Restcomm.getAuthID())));
		assertEquals(b.getFriendly_name(),"Paul");
		
	}
	public void testStatusUpdate() throws IOException, JAXBException {
		WireMock.stubFor(WireMock.put(WireMock.urlPathMatching("/Accounts.json/"+Restcomm.getAuthID()))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("Status=suspended"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile("Supdate.txt"))));
		
		
		
		b=b.modifyAccountDetails().newStatus("suspended").modify();
		
		WireMock.verify(WireMock.putRequestedFor(WireMock.urlEqualTo("/Accounts.json/"+Restcomm.getAuthID())));
		assertEquals(b.getStatus(),"suspended");
		
	}
	/*public void testPassUpdate() throws IOException, JAXBException {
		WireMock.stubFor(WireMock.put(WireMock.urlPathMatching("/Accounts.json/"+Restcomm.getAuthID()))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("Password=123456789abcd"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile("Supdate.txt"))));
		
		
		
		b=b.modifyAccountDetails().newPassword("123456789abcd").modify();
		
		WireMock.verify(WireMock.putRequestedFor(WireMock.urlEqualTo("/Accounts.json/"+Restcomm.getAuthID())));
		//assertEquals(b.getStatus(),"suspended");
		
	}*/
	@After
	public void afterTest()
	{
		b = null;
	}
}