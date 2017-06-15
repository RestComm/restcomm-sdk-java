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



public class SubAccountUpdaterTest extends BasicTest{
	
	private SubAccount b;
	private String SubAccountSid = "AC53444f91e698c0c7caa2dbc3bdbf93fc";
	
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8080);
	
	@Before
	public void beforeTest() throws IOException, JAXBException
	{
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts.json/"+SubAccountSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile("GetSResponse.txt"))));
		
		b = SubAccount.getSubAccount(SubAccountSid);
		
	}
	@Test
	public void testFriendlyNameUpdate() throws IOException, JAXBException {
		WireMock.stubFor(WireMock.put(WireMock.urlPathMatching("/Accounts.json/"+SubAccountSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("FriendlyName=Lion"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile("SFupdate.txt"))));
		
		
		
		b=b.modifySubAccountDetails().newFriendlyName("Lion").update();
		
		WireMock.verify(WireMock.putRequestedFor(WireMock.urlEqualTo("/Accounts.json/"+SubAccountSid)));
		assertEquals(b.getFriendly_name(),"Lion");
		
	}
	public void testStatusUpdate() throws IOException, JAXBException {
		WireMock.stubFor(WireMock.put(WireMock.urlPathMatching("/Accounts.json/"+SubAccountSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("Status=suspended"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody(readFile("SSupdate.txt"))));
		
		
		
		b=b.modifySubAccountDetails().newStatus("suspended").update();
		
		WireMock.verify(WireMock.putRequestedFor(WireMock.urlEqualTo("/Accounts.json/"+SubAccountSid)));
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