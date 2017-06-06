package org.restcomm.connect.java.sdk.Accounts;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.Credentials;
import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;

public class AccountUpdater{

	private static String BASE_URL = Constants.COMMON_URL+"Accounts/";
	private Request request;
	AccountUpdater()
	{
		request = new Request(HttpMethod.GET,BASE_URL+Credentials.getAuthID().replaceAll("@", "%40"));
	}
	public AccountUpdater newPassword(String value)
	{
		request.addPostParameters("Password", value);
		return this;
	}
	public AccountUpdater newStatus(String value)
	{
		request.addPostParameters("Status", value);
		return this;
	}
	public AccountUpdater newFriendlyName(String value)
	{
		request.addPostParameters("FriendlyName", value);
		return this;
	}
	
	public Account modify() throws ParseException, JAXBException, IOException
	{
		HttpClient client = new HttpClient(request);
		client.execute();
		return client.getObjectResponse().getAccount();
	}
}