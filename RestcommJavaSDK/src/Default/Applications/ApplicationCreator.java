package Default.Applications;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import Default.Constants;
import Default.Credentials;
import http.HttpClient;
import http.Request;
import http.HttpMethod;

public class ApplicationCreator {
	
	static String BASE_URL = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Applications/";
	public Request request;
	ApplicationCreator()
	{
		request = new Request(HttpMethod.POST,BASE_URL);
	}
	public ApplicationCreator(final String BASE_URL) {
		ApplicationCreator.BASE_URL = BASE_URL;
		request = new Request(HttpMethod.POST,BASE_URL);
	}
	public ApplicationCreator FriendlyName(String value)
	{
		request.addPostParameters("FriendlyName", value);
		return this;
	}
	public ApplicationCreator ApiVersion(String apiversion)
	{
		request.addPostParameters("ApiVersion", apiversion);
		return this;
	}
	public ApplicationCreator RcmlUrl(String rcmlurl)
	{
		request.addPostParameters("RcmlUrl", rcmlurl);
		return this;
	}
	public ApplicationCreator Kind(String kind)
	{
		request.addPostParameters("Kind", kind);
		return this;
	}
	public ApplicationCreator HasVoiceCallerIdLookup(String a)
	{
		request.addPostParameters("HasVoiceCallerIdLookup", a);
		return this;
	}
	public Application add() throws IOException, ParseException, JAXBException
	{
		HttpClient client = new HttpClient(request);
		client.execute();
		return client.getObjectResponse().getApplication();
	}

}
