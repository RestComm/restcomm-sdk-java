package org.restcomm.connect.java.sdk.EmailMessages;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;

public class EmailCreator {

	private Request request;
	public EmailCreator(String BASE_URL) {
		request = new Request(HttpMethod.POST,BASE_URL);
	}
	public EmailCreator From(String cc)
	{
		request.addPostParameters("From",cc);
		return this;
	}
	public EmailCreator Subject(String cc)
	{
		request.addPostParameters("Subject",cc);
		return this;
	}
	public EmailCreator To(String cc)
	{
		request.addPostParameters("To",cc);
		return this;
	}
	public EmailCreator Body(String cc)
	{
		request.addPostParameters("Body",cc);
		return this;
	}
	public EmailCreator BCC(String bcc)
	{
		request.addPostParameters("BCC",bcc);
		return this;
	}
	public EmailCreator CC(String cc)
	{
		request.addPostParameters("CC",cc);
		return this;
	}
	public EmailMessage sendEmail() throws IOException, ParseException, JAXBException
	{
		HttpClient client = new HttpClient(request);
		client.execute();
		return client.getObjectResponse().getEmailMessage();
	}

}
