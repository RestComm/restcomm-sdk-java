package org.restcomm.connect.java.sdk;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.Credentials;

public class BasicTest {

	@BeforeClass
    public static void runOnceBeforeClass() {
		
		Credentials.setAuthID("ACee72087d9be1903b60fc31e8aad3a8d3");        //Provide your AuthID and AuthToken here
		Credentials.setAuthToken("3358dfd6439e39dd1d908f64a9fa1e21");
		
		
		Constants.COMMON_URL = "https://cloud.restcomm.com/restcomm/2012-04-24/";
		System.out.println("@BeforeClass - runOnceBeforeClass");
    }
	@AfterClass
    public static void runOnceAfterClass() {
        
		Credentials.setAuthID(null);
		Credentials.setAuthToken(null);
		Constants.COMMON_URL=null;
		System.out.println("@AfterClass - runOnceAfterClass");
    
	}
	
}
