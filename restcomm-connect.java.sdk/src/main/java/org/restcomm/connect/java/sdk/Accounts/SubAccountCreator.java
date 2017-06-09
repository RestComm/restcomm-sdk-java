package org.restcomm.connect.java.sdk.Accounts;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.Credentials;
import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;

public class SubAccountCreator {

	private String BASE_URL;
	private Request request;
	private Boolean role= false;
	private Boolean password= false;
	private Boolean email= false;
	SubAccountCreator()
	{
		request = new Request(HttpMethod.POST,BASE_URL+Restcomm.getAuthID().replaceAll("@", "%40"));
	}
	public SubAccountCreator Role(String value)
	{
		role =true;
		request.addPostParameters("Role", value);
		return this;
	}
	public SubAccountCreator Email(String value)
	{
		email=true;
		request.addPostParameters("EmailAddress", value);
		return this;
	}
	public SubAccountCreator Password(String value)
	{
		password=true;
		request.addPostParameters("Password", value);
		return this;
	}
	public SubAccountCreator Status(String value)
	{
		request.addPostParameters("Status", value);
		return this;
	}
	public SubAccountCreator FriendlyName(String value)
	{
		request.addPostParameters("FriendlyName", value);
		return this;
	}
	public SubAccount create() throws IOException, ParseException, JAXBException
	{
		if(email && password && role)
		{
			Restcomm.sendRequest(request);	
			return (SubAccount)Utilities.AccountObject(Restcomm.getJSONResponse());
		}
		return null;

	}
}
