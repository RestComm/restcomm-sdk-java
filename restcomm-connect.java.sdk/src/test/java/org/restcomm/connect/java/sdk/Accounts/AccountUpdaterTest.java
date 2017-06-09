package org.restcomm.connect.java.sdk;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restcomm.connect.java.sdk.Accounts.*;

import org.restcomm.connect.java.sdk.Credentials;

import org.restcomm.connect.java.sdk.Constants;


public class AccountUpdaterTest extends BasicTest{
private Account b;
	
	@Before
	public void beforeTest() throws IOException, JAXBException 
	{
		
		b = Account.getAccount();
	}
	@Test
	public void testFriendlyNameUpdate() throws IOException, JAXBException {
		
		String spare = b.getFriendly_name();
		b = b.modifyAccountDetails().newFriendlyName("Paul").modify();
		assertNotNull("Updated Account Information not Received",b);
		assertEquals("Information not updated Accordingly",b.getFriendly_name(),"Paul");
		
		b.modifyAccountDetails().newFriendlyName(spare).modify();
	}
	
	
	/*@Test
	public void testStatusUpdate() throws IOException, JAXBException {
		String spare = b.getStatus();
		b = b.modifyAccountDetails().newStatus("closed").modify();
		assertNotNull("Updated Account Information not Received",b);
		assertEquals("Information not updated Accordingly",b.getStatus(),"closed");
		
		b.modifyAccountDetails().newStatus(spare).modify();
	}*/
	@Test
	public void testPasswordUpdate() throws IOException, JAXBException {
		
		
		//Will be done later
		
	}
	@After
	public void afterTest()
	{
		b = null;
	}
}
