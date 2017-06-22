package org.restcomm.connect.java.sdk.Clients;

import static org.junit.Assert.*;
import org.apache.http.ProtocolException;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.restcomm.connect.java.sdk.Clients.*;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.restcomm.connect.java.sdk.Exceptions.*;
import org.restcomm.connect.java.sdk.Restcomm;

import org.junit.rules.ExpectedException;
import java.io.IOException;

public class ClientTest extends BasicTest{
	
	private String path = "src/test/java/org/restcomm/connect/java/sdk/Clients/TextFiles/";
	private String ClientSid = "CL5ab96258ddf24c8e8e229467606ebda4";
	@Rule 
    public WireMockRule wireMockRule = new WireMockRule(8080);
	
	@Test
	public void testGetClient() throws Exception{ 
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Clients.json/"+ClientSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "Client/json")
				  .withBody(readFile(path+"getClient.txt"))));
		
		Client a = Client.getClient(ClientSid);
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Clients.json/"+ClientSid)));
		assertEquals(200, Restcomm.getStatusCode());
		assertEquals(ClientSid,a.getSid());
	}
	@Test
	public void testAddClient() throws Exception{
		
		WireMock.stubFor(WireMock.post(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Clients.json/"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				   .withRequestBody(WireMock.containing("Login=paras"))
				   .withRequestBody(WireMock.containing("Password=Paras%40123"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "Client/json")
				  .withBody(readFile(path+"getClient.txt"))));
		
		Client a = Client.createClient().Login("paras").Password("Paras@123").create();
		
		
		WireMock.verify(WireMock.postRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Clients.json/")));
		assertEquals(200,Restcomm.getStatusCode());
		assertEquals("paras",a.getLogin());
		
	}
	@Test
	public void testUpdateClient()throws Exception{
		
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Clients.json/"+ClientSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "Client/json")
				  .withBody(readFile(path+"getClient.txt"))));
		
		Client a = Client.getClient(ClientSid);
		assertEquals("paras",a.getFriendly_name());
		
		WireMock.stubFor(WireMock.put(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Clients.json/"+ClientSid))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .withRequestBody(WireMock.containing("FriendlyName=Martin"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "Client/json")
				  .withBody(readFile(path+"getUClient.txt"))));
		
		 a = a.updateClient().newFriendlyName("Martin").update();
		
		
		WireMock.verify(WireMock.putRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Clients.json/"+ClientSid)));
		assertEquals(200,Restcomm.getStatusCode());
		assertEquals("Martin",a.getFriendly_name());
		
	}
	@Test
	public void testClientList() throws Exception{
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/Accounts/"+Restcomm.getAuthID()+"/Clients.json/"))
				  .withBasicAuth(Restcomm.getAuthID(),Restcomm.getPassword())
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "Client/json")
				  .withBody(readFile(path+"getClientList.txt"))));
		
		ClientList a = Client.getClientList();
		
		Client b = a.get(0);
		Client c = a.get(1);
		
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/Accounts/"+Restcomm.getAuthID()+"/Clients.json/")));
		assertEquals(200,Restcomm.getStatusCode());
		assertNotNull(a);
		assertEquals("democlients",b.getFriendly_name());
		assertEquals("paras",c.getFriendly_name());

	}
}