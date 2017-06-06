package org.restcomm.connect.java.sdk.Clients;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;

public class ClientUpdater {

	Request request;
	ClientUpdater()
	{
	}
	public ClientUpdater(String sid,String BASE_URL) {
		request = new Request(HttpMethod.PUT,BASE_URL+sid);
	}
	public ClientUpdater newFriendlyName(String value)
	{
		request.addPostParameters("FriendlyName", value);
		return this;
	}
	public ClientUpdater newPassword(String kind)
	{
		request.addPostParameters("Password", kind);
		return this;
	}
	public ClientUpdater newStatus(String rcmlurl)
	{
		request.addPostParameters("Status", rcmlurl);
		return this;
	}
	public ClientUpdater newVoiceUrl(String kind)
	{
		request.addPostParameters("VoiceUrl", kind);
		return this;
	}
	public ClientUpdater newVoiceFallbackUrl(String rcmlurl)
	{
		request.addPostParameters("VoiceFallbackUrl", rcmlurl);
		return this;
	}
	public ClientUpdater newVoiceFallbackMethod(String kind)
	{
		request.addPostParameters("VoiceFallbackMethod", kind);
		return this;
	}
	public ClientUpdater newVoiceApplicationSid(String kind)
	{
		request.addPostParameters("VoiceApplicationSid", kind);
		return this;
	}
	public Client update() throws IOException, ParseException, JAXBException
	{
		HttpClient client = new HttpClient(request);
		client.execute();
		return client.getObjectResponse().getClient();
	}
}
