package Default.Accounts;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import Default.Constants;
import http.HttpClient;
import http.HttpMethod;
import http.Request;

public class SubAccountUpdater {
	private static String BASE_URL = Constants.COMMON_URL+"Accounts/";
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
		HttpClient client = new HttpClient(request);
		client.execute();
		return client.getObjectResponse().getAccount();
	}

}
