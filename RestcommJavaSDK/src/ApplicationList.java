import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Applications")
public class ApplicationList {
	
	public String BASE_URL = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Applications";
	@XmlElement(name = "Application")
	private ArrayList<Application> List;

	public ArrayList<Application> getList() {
		return List;
	}

	public void setList(ArrayList<Application> list) {
		List = list;
	}
	
	public ApplicationList getApplicationList() throws IOException
    {
		Request request = new Request(BASE_URL);
		HttpMethod http = new HttpMethod("GET",request);
		Response object = http.execute();
		return object.getApplicationList();
	}
}	
