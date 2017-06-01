package Default.Applications;
import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.ParseException;

import Default.Constants;
import Default.Credentials;
import Default.Resource;
import http.HttpClient;
import http.HttpMethod;
import http.Request;

@XmlRootElement(name = "Application")
public class Application extends Resource{
	
	static String BASE_URL = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Applications/";
	
	static public void SubAccountAccess(String sid)     //To access the Applications connected to SubAccounts
	{
		BASE_URL = Constants.COMMON_URL+"Accounts/"+sid+"/Applications/";
	}
	public static Application getApplication(String sid) throws IOException, ParseException, JAXBException
	{
		HttpClient client = new HttpClient(new Request(HttpMethod.GET,BASE_URL+sid));
		client.execute();
		return client.getObjectResponse().getApplication();
	}
	public static ApplicationCreator addApplication() throws IOException
	{
		return new ApplicationCreator(BASE_URL);
	}
	public ApplicationUpdater modifyApplication() throws IOException
	{
		return new ApplicationUpdater(this.getSid(),BASE_URL);
	}
	public static ApplicationUpdater updateApplication(String sid)
	{
		return new ApplicationUpdater(sid,BASE_URL);
	}
	public ApplicationUpdater updateApplication()
	{
		return new ApplicationUpdater(this.getSid(),BASE_URL);
	}
	public void deleteApplication() throws IOException, ParseException, JAXBException
	{
		deleteApplication(this.getSid());
	}
	public static void deleteApplication(String sid) throws IOException, ParseException, JAXBException
	{
		HttpClient client = new HttpClient(new Request(HttpMethod.DELETE,BASE_URL+sid));
		client.execute();
	}

	
	
	
	
	
	
}
