package Default.Accounts;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import Default.Constants;
import Default.Credentials;
import http.HttpClient;
import http.HttpMethod;
import http.Request;

public class SubAccountCreator {

	private static String BASE_URL = Constants.COMMON_URL+"Accounts/";
	private Request request;
	private Boolean role= false;
	private Boolean password= false;
	private Boolean email= false;
	SubAccountCreator()
	{
		request = new Request(HttpMethod.POST,BASE_URL+Credentials.getAuthID().replaceAll("@", "%40"));
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
		HttpClient client = new HttpClient(request);
		client.execute();
		return client.getObjectResponse().getAccount();
		}
		return null;

	}
}
