package Default;
import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

import http.Request;
import http.Response;

@XmlRootElement(name="IncomingPhoneNumber")
public class IncomingPhoneNumber extends Resource {
	public String BASE_URL= "https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/IncomingPhoneNumbers";
	private HttpMethod http;
	protected Request request;
	public IncomingPhoneNumber getIncomingPhoneNumber(String sid) throws IOException
	{
		request = new Request(BASE_URL+"/"+sid);
		http = new HttpMethod("GET",request);
		Response a = http.execute();
		return a.getIncomingPhoneNumber();
	}
}
