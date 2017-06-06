package org.restcomm.connect.java.sdk.Accounts;

import org.restcomm.connect.java.sdk.http.*;
import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.Credentials;

@XmlRootElement(name = "Account")
public class Account extends SubAccount{
	
	private static String BASE_URL = Constants.COMMON_URL+"Accounts/";
	
	public static Account getAccount() 
	{
		HttpClient client = new HttpClient(new Request(HttpMethod.GET,BASE_URL+Credentials.getAuthID().replaceAll("@", "%40")));
		try {
			
			client.execute();
			
		} catch (ParseException e) {
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client.getObjectResponse().getAccount();
	}

	public AccountUpdater modifyAccountDetails()
	{
		return new AccountUpdater();
	}
	
}
