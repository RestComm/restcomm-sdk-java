package org.restcomm.connect.java.sdk.Clients;


import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.Credentials;
import org.restcomm.connect.java.sdk.Resource;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;
@XmlRootElement(name = "Client")
public class Client extends Resource {

	static String BASE_URL = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Clients/";
	
	static public void SubAccountAccess(String sid)     //To access the Applications connected to SubAccounts
	{
		BASE_URL = Constants.COMMON_URL+"Accounts/"+sid+"/Clients/";
	}
	public Client getClient(String sid) throws IOException, ParseException, JAXBException
	{
		HttpClient client = new HttpClient(new Request(HttpMethod.GET,BASE_URL+sid));
		client.execute();
		return client.getObjectResponse().getClient();
	}
	public static ClientCreator addClient()
	{
		return new ClientCreator(BASE_URL);
	}
	public static ClientUpdater updateClient(String sid)
	{
		return new ClientUpdater(sid,BASE_URL);
	}
	public ClientUpdater updateClient()
	{
		return new ClientUpdater(this.getSid(),BASE_URL);
	}
	public void delete() throws IOException, ParseException, JAXBException
	{
		deleteClient(this.getSid());
	}
	public static void deleteClient(String sid) throws IOException, ParseException, JAXBException
	{
		HttpClient client = new HttpClient(new Request(HttpMethod.DELETE,BASE_URL+sid));
		client.execute();
	}

}
