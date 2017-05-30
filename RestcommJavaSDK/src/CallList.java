import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Calls")
public class CallList {
	private String BASE_URL = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Calls";
	
	
	@XmlElement(name = "Call")
	private ArrayList<Call> List;

    public ArrayList<Call> getList()
    {
        return List;
    }

    public void setList (ArrayList<Call> List)
    {
        this.List = List;
    }

    public CallList getCallsList() throws IOException
    {
		Request request = new Request(BASE_URL);
		HttpMethod http = new HttpMethod("GET",request);
		Response object = http.execute();
		return object.getCallList();
	}
    public FilteredCallList getFilteredCallsList()
    {
    	Request request = new Request(BASE_URL);
		FilteredCallList b = new FilteredCallList();
    	b.request = request;
		return b;
    }
    public class FilteredCallList{
    	Request request;
    	public FilteredCallList From(String value) throws MalformedURLException, URISyntaxException 
    	{
    		request.addGetParameters("From", value);
    		return this;
    	}
    	public FilteredCallList To(String value) throws MalformedURLException, URISyntaxException
    	{
    		request.addGetParameters("To", value);
    		return this;
    	}
    	public FilteredCallList Status(String value) throws MalformedURLException, URISyntaxException
    	{
    		request.addGetParameters("Status", value);
    		return this;
    	}
    	public FilteredCallList StartTime(String value) throws MalformedURLException, URISyntaxException
    	{
    		request.addGetParameters("StartTime", value);
    		return this;
    	}
    	public FilteredCallList ParentCallSid(String value) throws MalformedURLException, URISyntaxException
    	{
    		request.addGetParameters("ParentCallSid", value);
    		return this;
    	}
    	public CallList search() throws IOException
    	{
    		HttpMethod http = new HttpMethod("GET",request);
    		Response object = http.execute();
    		//System.out.println(object.getSMS().getSMSMessages()[0].getSid());
    		return object.getCallList();
    		
    	}
    }
    
    
    
    
    //Paging wasnt handled by you
}
