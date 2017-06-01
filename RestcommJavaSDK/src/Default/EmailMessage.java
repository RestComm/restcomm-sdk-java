package Default;
import java.io.IOException;

import http.Request;

public class EmailMessage extends Resource{
	public String BASE_URL = "https://ACee72087d9be1903b60fc31e8aad3a8d3:3358dfd6439e39dd1d908f64a9fa1e21@cloud.restcomm.com/restcomm/2012-04-24/Accounts/ACee72087d9be1903b60fc31e8aad3a8d3/Email/Messages";
	private HttpMethod http;
	private Request request;
	public EmailMessage(){}
	public EmailMessage(String from,String to,String body,String subject) throws IOException
	{
		request = new Request(BASE_URL);
		request.addPostParameters("From",from);
		request.addPostParameters("To",to);
		request.addPostParameters("Body",body);
		request.addPostParameters("Subject",subject);
	}
	public EmailMessage addEmailBCC(String bcc)
	{
		request.addPostParameters("BCC",bcc);
		return this;
	}
	public EmailMessage addEmailCC(String cc)
	{
		request.addPostParameters("CC",cc);
		return this;
	}
	public void sendEmail() throws IOException
	{
		http = new HttpMethod("POST",request);
		http.execute();
	}
}
