package Default.Accounts;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import Default.Constants;
import Default.Credentials;
import http.HttpClient;
import http.HttpMethod;
import http.Request;

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
	
	public Account modify() throws IOException, JAXBException
	{
		HttpClient client = new HttpClient(request);
		client.execute();
		return client.getObjectResponse().getAccount();
	}
}