package org.restcomm.connect.java.sdk.Clients;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.Credentials;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;

public class ClientCreator {

	String BASE_URL = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Clients/";
	public Request request;
	ClientCreator()
	{
	}
	public ClientCreator(String BASE_URL) {
		this.BASE_URL= BASE_URL;
		request = new Request(HttpMethod.PUT,BASE_URL);
	}
	public ClientCreator newFriendlyName(String value)
	{
		request.addPostParameters("FriendlyName", value);
		return this;
	}
	public ClientCreator newLogin(String value)
	{
		request.addPostParameters("Login", value);
		return this;
	}
	public ClientCreator newPassword(String kind)
	{
		request.addPostParameters("Password", kind);
		return this;
	}
	public ClientCreator newStatus(String rcmlurl)
	{
		request.addPostParameters("Status", rcmlurl);
		return this;
	}
	public ClientCreator newVoiceUrl(String kind)
	{
		request.addPostParameters("VoiceUrl", kind);
		return this;
	}
	public ClientCreator newVoiceMethod(String kind)
	{
		request.addPostParameters("VoiceMethod", kind);
		return this;
	}
	public ClientCreator newVoiceFallbackUrl(String rcmlurl)
	{
		request.addPostParameters("VoiceFallbackUrl", rcmlurl);
		return this;
	}
	public ClientCreator newVoiceFallbackMethod(String kind)
	{
		request.addPostParameters("VoiceFallbackMethod", kind);
		return this;
	}
	public ClientCreator newVoiceApplicationSid(String kind)
	{
		request.addPostParameters("VoiceApplicationSid", kind);
		return this;
	}
	public Client add() throws IOException, ParseException, JAXBException
	{
		HttpClient client = new HttpClient(request);
		client.execute();
		return client.getObjectResponse().getClient();
	}

}
