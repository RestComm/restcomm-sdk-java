package Default;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import http.Request;
import http.Response;
@XmlRootElement(name = "SMSMessage")
public class SMSMessage extends Resource{
	
	private String BASE_URL = "https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/SMS/Messages/";
	
	@XmlElement(name="DateSent")
	private String DateSent;
	@XmlElement(name="From")
	private String From;
	@XmlElement(name="To")
	private String To;
	@XmlElement(name="Body")
	private String Body;
	@XmlElement(name="Status")
	private String Status;
	@XmlElement(name="Direction")
	private String Direction;
	@XmlElement(name="Uri")
	private String Uri;
	public String getDateSent() {
		return DateSent;
	}
	public void setDateSent(String dateSent) {
		DateSent = dateSent;
	}
	public String getFrom() {
		return From;
	}
	public void setFrom(String from) {
		From = from;
	}
	public String getBody() {
		return Body;
	}
	public void setBody(String body) {
		Body = body;
	}
	public String getTo() {
		return To;
	}
	public void setTo(String to) {
		To = to;
	}
	public String getDirection() {
		return Direction;
	}
	public void setDirection(String direction) {
		Direction = direction;
	}
	public String getUri() {
		return Uri;
	}
	public void setUri(String uri) {
		Uri = uri;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	public SMSMessage getSMSMessage(String sid) throws IOException
	{
		Request request = new Request(BASE_URL+sid);
		HttpMethod http = new HttpMethod("GET",request);
		Response object = http.execute();
		return object.getSMSMessage();
	}
	public void sendSMSMessage(String from,String to,String body) throws IOException
	{
		Request request = new Request(BASE_URL);
		
		//Here the from and to numbers need to be encode which wasnt handled yet by me.
		request.addPostParameters("From",from.replace("+","%2B"));
		request.addPostParameters("To",to.replace("+","%2B"));
		request.addPostParameters("Body",body);
		HttpMethod http = new HttpMethod("POST",request);
		http.execute();
	}
	
	
	
}
