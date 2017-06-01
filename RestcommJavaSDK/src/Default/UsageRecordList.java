package Default;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import http.Request;
import http.Response;


@XmlRootElement(name="UsageRecordList")
public class UsageRecordList {
	String BASE_URL = "https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/Usage/Records";

	@XmlElement(name="UsageRecord")
	private ArrayList<UsageRecord> List;

	public ArrayList<UsageRecord> getList() {
		return List;
	}

	public void setList(ArrayList<UsageRecord> list) {
		List = list;
	}
	 	public UsageRecordList getUsageRecordList() throws IOException
	    {
			Request request = new Request(BASE_URL);
			HttpMethod http = new HttpMethod("GET",request);
			Response object = http.execute();
			System.out.println(object.getSMS().getSMSMessages()[0].getSid());
			return object.getUsageRecordList();
		}
	    public FilteredUsageRecordList getFilteredUsageRecordList()
	    {
	    	return new FilteredUsageRecordList();
	    }
	    public class FilteredUsageRecordList extends UsageRecordList{
	    	Request frequest = new Request("https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/Calls");
	    	
	    	public FilteredUsageRecordList addSearchParameters(String parameter,String value) throws MalformedURLException, URISyntaxException
	    	{
	    		frequest.addGetParameters(parameter, value);
	    		return this;
	    	}
	    	public UsageRecordList search() throws IOException
	    	{
	    		HttpMethod http = new HttpMethod("GET",frequest);
	    		Response object = http.execute();
	    		//System.out.println(object.getSMS().getSMSMessages()[0].getSid());
	    		return object.getUsageRecordList();
	    		
	    	}
	    }
	    public UsageRecordList getUsageRecordList(String subresource) throws IOException
	    {
			Request request = new Request(BASE_URL+"/subresource");
			HttpMethod http = new HttpMethod("GET",request);
			Response object = http.execute();
			System.out.println(object.getSMS().getSMSMessages()[0].getSid());
			return object.getUsageRecordList();
		}
}
