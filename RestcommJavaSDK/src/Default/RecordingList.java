package Default;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import http.Request;
import http.Response;

@XmlRootElement(name = "Recordings")
public class RecordingList {
	String BASE_URL = "https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/Recordings";
	@XmlElement(name = "Recording")
	private ArrayList<Recording> List;

	public ArrayList<Recording> getList() {
		return List;
	}

	public void setList(ArrayList<Recording> list) {
		List = list;
	}
	public RecordingList getRecordingList() throws IOException
    {
		Request request = new Request(BASE_URL);
		HttpMethod http = new HttpMethod("GET",request);
		Response object = http.execute();
		System.out.println(object.getSMS().getSMSMessages()[0].getSid());
		return object.getRecordingList();
	}
	public FilteredRecordingList getFilteredRecordingList()
    {
    	return new FilteredRecordingList();
    }
    public class FilteredRecordingList extends RecordingList{
    	Request frequest = new Request("https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/Recordings");
    	
    	public FilteredRecordingList addSearchParameters(String parameter,String value) throws MalformedURLException, URISyntaxException
    	{
    		frequest.addGetParameters(parameter, value);
    		return this;
    	}
    	public RecordingList search() throws IOException
    	{
    		HttpMethod http = new HttpMethod("GET",frequest);
    		Response object = http.execute();
    		//System.out.println(object.getSMS().getSMSMessages()[0].getSid());
    		return object.getRecordingList();
    		
    	}
    }
	
}
