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


public class AccountTest extends BasicTest{

	

	@Test
	public void testGetAccount() throws IOException, JAXBException {
		Account a = Account.getAccount();
		
		assertNotNull("No Account Fetched received",a);
		assertEquals("Correct Account Not Fetched",Restcomm.getAuthID(),a.getSid());
	}
	
	

}
