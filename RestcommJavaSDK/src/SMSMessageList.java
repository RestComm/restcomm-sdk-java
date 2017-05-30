import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SMSMessages")
public class SMSMessageList {
	private String BASE_URL = "https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/SMS/Messages/";
	
	@XmlElement(name="SMSMessage")
	private SMSMessage[] SMSMessages;
	
    public SMSMessage[] getSMSMessages()
    {
        return SMSMessages;
    }

    public void setSMSMessageList (SMSMessage[] SMSMessages)
    {
        this.SMSMessages = SMSMessages;
    }
    
    public SMSMessageList getSMSMessageList() throws IOException
    {
		Request request = new Request(BASE_URL);
		HttpMethod http = new HttpMethod("GET",request);
		Response object = http.execute();
		System.out.println(object.getSMS().getSMSMessages()[0].getSid());
		return object.getSMS();
	}
    public FilteredSMSMessageList getFilteredSMSMessageList()
    {
    	return new FilteredSMSMessageList();
    }
    public class FilteredSMSMessageList extends SMSMessageList{
    	Request frequest = new Request("https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/SMS/Messages");
    	
    	public FilteredSMSMessageList addSearchParameters(String parameter,String value) throws MalformedURLException, URISyntaxException
    	{
    		frequest.addGetParameters(parameter, value);
    		return this;
    	}
    	public SMSMessageList search() throws IOException
    	{
    		HttpMethod http = new HttpMethod("GET",frequest);
    		Response object = http.execute();
    		//System.out.println(object.getSMS().getSMSMessages()[0].getSid());
    		return object.getSMS();
    		
    	}
    }
    
    
    
    
    //Paging wasnt handled by you
}

