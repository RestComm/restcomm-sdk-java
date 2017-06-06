package org.restcomm.connect.java.sdk.Accounts;


import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.Resource;
import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;
@XmlRootElement(name = "Account")

public class SubAccount extends Resource{
	
	private static String BASE_URL = Constants.COMMON_URL+"Accounts/";
	private Request request;
	public static SubAccount getSubAccount(String emailorauthID) throws IOException, ParseException, JAXBException
	{	
		HttpClient client = new HttpClient(new Request(HttpMethod.GET,BASE_URL+emailorauthID.replaceAll("@","%40")));
		client.execute();
		return (SubAccount)client.getObjectResponse().getAccount();
	}
	public static SubAccountCreator addSubAccount()
	{
		return new SubAccountCreator();
	}
	public SubAccountUpdater modifySubAccount()
	{
		return new SubAccountUpdater(this.getSid());	
	}
	public static SubAccountUpdater modifySubAccount(String sid)
	{
		return new SubAccountUpdater(sid);
	}
	public void closeSubAccount() throws IOException, ParseException, JAXBException
	{
		request = new Request(HttpMethod.POST,BASE_URL+this.getSid());
		request.addPostParameters("Status", "closed");
		HttpClient client = new HttpClient(request);
		client.execute();
	}
	public static void closeSubAccount(String sid) throws IOException, ParseException, JAXBException
	{
		Request request = new Request(HttpMethod.POST,BASE_URL+sid);
		request.addPostParameters("Status", "closed");
		HttpClient client = new HttpClient(request);
		client.execute();
	}

}

