package org.restcomm.connect.java.sdk.Accounts;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;

import Default.Restcomm;
import Default.Accounts.SubAccount;
import Default.Accounts.SubAccountUpdater;
import Default.test.Utilities;

public class SubAccountUpdater {
	private String BASE_URL;
	private Request request;
	SubAccountUpdater()
	{
	}
	public SubAccountUpdater(String sid) {
		request = new Request(HttpMethod.PUT,BASE_URL+sid.replaceAll("@", "%40"));
	}
	public SubAccountUpdater newRole(String value)
	{
		request.addPostParameters("Role", value);
		return this;
	}
	public SubAccountUpdater newEmail(String value)
	{
		request.addPostParameters("EmailAddress", value);
		return this;
	}
	public SubAccountUpdater newPassword(String value)
	{
		request.addPostParameters("Password", value);
		return this;
	}
	public SubAccountUpdater newStatus(String value)
	{
		request.addPostParameters("Status", value);
		return this;
	}
	public SubAccountUpdater newFriendlyName(String value)
	{
		request.addPostParameters("FriendlyName", value);
		return this;
	}
	public SubAccount create() throws IOException, ParseException, JAXBException
	{
		Restcomm.sendRequest(request);
		return (SubAccount)Utilities.AccountObject(Restcomm.getJSONResponse());
	}

}
