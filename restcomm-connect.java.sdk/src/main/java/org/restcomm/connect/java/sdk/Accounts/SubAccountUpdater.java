package org.restcomm.connect.java.sdk.Accounts;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.http.*;

import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Accounts.SubAccount;
import org.restcomm.connect.java.sdk.Accounts.SubAccountUpdater;
import org.restcomm.connect.java.sdk.Utilities;

public class SubAccountUpdater {
	private String BASE_URL;
	private Request request;
	SubAccountUpdater()
	{
	}
	public SubAccountUpdater(final String BASE_URL) {
		request = new Request(HttpMethod.PUT,BASE_URL);
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
	public SubAccount update() throws IOException, ParseException, JAXBException
	{
		Restcomm.sendRequest(request);
		return (SubAccount)Utilities.AccountObject(Restcomm.getJSONResponse());
	}

}
