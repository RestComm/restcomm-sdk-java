package Default.Applications;
import http.HttpClient;
import http.HttpMethod;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.ParseException;

import Default.Constants;
import Default.Credentials;
import http.Request;

@XmlRootElement(name = "Applications")
public class ApplicationList {
	
	public String BASE_URL = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Applications";
	public void SubAccountAccess(String sid)
	{
		BASE_URL = Constants.COMMON_URL+"Accounts/"+sid+"/Applications";
	}
	@XmlElement(name = "Application")
	private ArrayList<Application> List;

	public ArrayList<Application> getList() {
		return List;
	}
	public Application get(int index)
	{
		return List.get(index);
	}
	public void setList(ArrayList<Application> list) {
		List = list;
	}
	
	public ApplicationList getApplicationList() throws IOException, ParseException, JAXBException
    {
		
		HttpClient client = new HttpClient(new Request(HttpMethod.GET,BASE_URL));
		client.execute();
		return client.getObjectResponse().getApplicationList();
	}
}	
