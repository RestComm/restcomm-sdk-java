import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Notification")
public class Notification {
	public String BASE_URL= "https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/Notifications";
	private HttpMethod http;
	protected Request request;
	public Notification getNotification(String sid) throws IOException
	{
		request = new Request(BASE_URL+"/"+sid);
		http = new HttpMethod("GET",request);
		Response a = http.execute();
		return a.getNotification();
	}
}
