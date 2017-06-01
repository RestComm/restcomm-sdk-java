package Default.Calls;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;
import http.HttpClient;
import http.HttpMethod;
import http.Request;

public class CallModifer {
		
	Request request;
	private static String BASE_URL;
	CallModifer()
	{
	}
	
	public CallModifer(String sid,final String BASE_URL) {
		CallModifer.BASE_URL = BASE_URL;
		request = new Request(HttpMethod.POST,BASE_URL+sid);
	}
	public CallModifer newUrl(String value)
	{
		request.addPostParameters("Url", value);
		return this;
	}
	public CallModifer newMethod(String value)
	{
		request.addPostParameters("Method", value);
		return this;
	}
	public CallModifer newStatus(String value)
	{
		request.addPostParameters("Status", value);
		return this;
	}
	public CallModifer newMute(String value)
	{
		request.addPostParameters("Mute", value);
		return this;
	}
	public CallModifer statusCallback(String value)
	{
		request.addPostParameters("statusCallback", value);
		return this;
	}
	public CallModifer statusCallbackMethod(String value)
	{
		request.addPostParameters("statusCallbackMethod", value);
		return this;
	}
	public CallModifer FallbackUrl(String value)
	{
		request.addPostParameters("FallbackUrl", value);
		return this;
	}
	public CallModifer FallbackMethod(String value)
	{
		request.addPostParameters("FallbackMethod", value);
		return this;
	}
	public CallModifer MoveConnectedCallLeg(String value)
	{
		request.addPostParameters("MoveConnectedCallLeg", value);
		return this;
	}
	
	public Call modify() throws IOException, ParseException, JAXBException
	{
		HttpClient client = new HttpClient(request);
		client.execute();
		return client.getObjectResponse().getCall();
	}
}
