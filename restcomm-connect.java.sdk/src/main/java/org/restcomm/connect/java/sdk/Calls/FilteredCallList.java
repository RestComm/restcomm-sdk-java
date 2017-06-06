package org.restcomm.connect.java.sdk;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.Calls.CallList;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;
import org.restcomm.connect.java.sdk.http.Response;

public class FilteredCallList{
	private String BASE_URL;
	Request request;
	public FilteredCallList(final String BASE_URL)
	{
		this.BASE_URL = BASE_URL;
		request = new Request(HttpMethod.GET,BASE_URL);
	}
	public FilteredCallList Page(String value) throws MalformedURLException, URISyntaxException
	{
		request.addGetParameters("Page", value);
		return this;
	}
	public FilteredCallList NumPage(String value) throws MalformedURLException, URISyntaxException 
	{
		request.addGetParameters("NumPage", value);
		return this;
	}
	public FilteredCallList PageSize(String value) throws MalformedURLException, URISyntaxException 
	{
		request.addGetParameters("PageSize", value);
		return this;
	}
	public FilteredCallList Total(String value) throws MalformedURLException, URISyntaxException 
	{
		request.addGetParameters("Total", value);
		return this;
	}
	public FilteredCallList Start(String value) throws MalformedURLException, URISyntaxException 
	{
		request.addGetParameters("Start", value);
		return this;
	}
	public FilteredCallList End(String value) throws MalformedURLException, URISyntaxException 
	{
		request.addGetParameters("End", value);
		return this;
	}
	public FilteredCallList From(String value) throws MalformedURLException, URISyntaxException 
	{
		request.addGetParameters("From", value);
		return this;
	}
	public FilteredCallList To(String value) throws MalformedURLException, URISyntaxException
	{
		request.addGetParameters("To", value);
		return this;
	}
	public FilteredCallList Status(String value) throws MalformedURLException, URISyntaxException
	{
		request.addGetParameters("Status", value);
		return this;
	}
	public FilteredCallList StartTime(String value) throws MalformedURLException, URISyntaxException
	{
		request.addGetParameters("StartTime", value);
		return this;
	}
	public FilteredCallList ParentCallSid(String value) throws MalformedURLException, URISyntaxException
	{
		request.addGetParameters("ParentCallSid", value);
		return this;
	}
	public CallList search() throws IOException, ParseException, JAXBException
	{
		HttpClient client = new HttpClient(request);
		client.execute();
		return client.getObjectResponse().getCallList();
		
	}
}
