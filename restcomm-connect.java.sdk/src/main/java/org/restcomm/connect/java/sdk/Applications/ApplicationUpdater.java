package org.restcomm.connect.java.sdk.Applications;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;

public class ApplicationUpdater {

	Request request;
	ApplicationUpdater()
	{
	}
	public ApplicationUpdater(String sid,String BASE_URL) {
		request = new Request(HttpMethod.PUT,BASE_URL+sid);
	}
	public ApplicationUpdater newFriendlName(String value)
	{
		request.addPostParameters("FriendlyName", value);
		return this;
	}
	public ApplicationUpdater newRcmlUrl(String rcmlurl)
	{
		request.addPostParameters("RcmlUrl", rcmlurl);
		return this;
	}
	public ApplicationUpdater newKind(String kind)
	{
		request.addPostParameters("Kind", kind);
		return this;
	}
	public ApplicationUpdater HasVoiceCallerIdLookup(String a)
	{
		request.addPostParameters("HasVoiceCallerIdLookup", a);
		return this;
	}
	public Application update() throws IOException, ParseException, JAXBException
	{
		HttpClient client = new HttpClient(request);
		client.execute();
		return client.getObjectResponse().getApplication();
	}
}
