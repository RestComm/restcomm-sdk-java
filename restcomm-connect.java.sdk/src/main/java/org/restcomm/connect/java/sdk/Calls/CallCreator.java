package org.restcomm.connect.java.sdk.Calls;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;

public class CallCreator {
	
	static String BASE_URL;
	public Request request;
	CallCreator()
	{
		request = new Request(HttpMethod.POST,BASE_URL);
	}
	public CallCreator(final String BASE_URL) {
		CallCreator.BASE_URL = BASE_URL;
		request = new Request(HttpMethod.POST,BASE_URL);
	}
	public CallCreator From(String value)
	{
		request.addPostParameters("From", value);
		return this;
	}
	public CallCreator To(String value)
	{
		request.addPostParameters("To", value);
		return this;
	}
	public CallCreator Url(String value)
	{
		request.addPostParameters("Url", value);
		return this;
	}
	public CallCreator Method(String value)
	{
		request.addPostParameters("Method", value);
		return this;
	}
	public CallCreator FallbackUrl(String value)
	{
		request.addPostParameters("FallbackUrl", value);
		return this;
	}
	public CallCreator FallbackMethod(String value)
	{
		request.addPostParameters("FallbackMethod", value);
		return this;
	}
	public CallCreator statusCallbackEvent(String value)
	{
		request.addPostParameters("statusCallbackEvent", value);
		return this;
	}
	public CallCreator statusCallback(String value)
	{
		request.addPostParameters("statusCallback", value);
		return this;
	}
	public CallCreator statusCallbackMethod(String value)
	{
		request.addPostParameters("statusCallbackMethod", value);
		return this;
	}
	public CallCreator Timeout(String value)
	{
		request.addPostParameters("Timeout", value);
		return this;
	}
	public Call makeCall() throws IOException, ParseException, JAXBException
	{
		HttpClient client = new HttpClient(request);
		client.execute();
		return client.getObjectResponse().getCall();
	}

}
