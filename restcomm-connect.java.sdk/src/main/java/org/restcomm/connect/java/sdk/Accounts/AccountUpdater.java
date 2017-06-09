package org.restcomm.connect.java.sdk.Accounts;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.Credentials;
import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;

import Default.Restcomm;
import Default.Accounts.Account;
import Default.Accounts.AccountUpdater;
import Default.test.Utilities;

public class AccountUpdater {

	private Request request;
	AccountUpdater(final String BASE_URL)
	{
		request = new Request(HttpMethod.PUT,BASE_URL+Restcomm.getAuthID().replaceAll("@", "%40"));
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
	
	public Account modify() throws IOException, JAXBException
	{
		Restcomm.sendRequest(request);	
		return Utilities.AccountObject(Restcomm.getJSONResponse());
	}
}