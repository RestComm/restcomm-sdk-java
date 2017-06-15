package org.restcomm.connect.java.sdk.Accounts;

import java.io.IOException;

import javax.naming.InsufficientResourcesException;
import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.Utilities;
import org.restcomm.connect.java.sdk.http.*;

import org.restcomm.connect.java.sdk.Restcomm;
public class SubAccountCreator {


	private Request request;
	private Boolean role= false;
	private Boolean password= false;
	private Boolean email= false;
	SubAccountCreator(final String BASE_URL)
	{
		request = new Request(HttpMethod.POST,BASE_URL);
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
		//try
		//{
			//if(email && password && role)
			//{
				Restcomm.sendRequest(request);
				//System.out.println(Restcomm.getJSONResponse());
				return (SubAccount)Utilities.AccountObject(Restcomm.getJSONResponse());
			//}
			//else throw new InsufficientResourcesException("You need to specify Email,Password and Role for this request");
		//}
		//catch(InsufficientResourcesException e)
		//{
			//System.out.println(e);
			//e.printStackTrace();
		//}
		//return null;

	}
}
