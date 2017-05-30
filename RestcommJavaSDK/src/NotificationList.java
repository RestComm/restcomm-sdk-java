import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Notifications")
public class NotificationList {
	
		public String BASE_URL= "https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/Notifications";
		@XmlElement(name = "Notification")
		public ArrayList<Notification> List;
		
		public ArrayList<Notification> getList ()
	    {
	        return List;
	    }

	    public void setList (ArrayList<Notification> List)
	    {
	        this.List = List;
	    }
	    public NotificationList getNewList() throws IOException
	    {
			Request request = new Request(BASE_URL);
			HttpMethod http = new HttpMethod("GET",request);
			Response object = http.execute();
			this.setList(object.getNotificationList().getList());
			return this;
		}
	    public FilteredNotificationList getFilteredNotificationList()
	    {
	    	return new FilteredNotificationList();
	    }
	    public class FilteredNotificationList extends NotificationList{
	    	Request frequest = new Request(BASE_URL);
	    	
	    	public FilteredNotificationList addSearchParameters(String parameter,String value) throws MalformedURLException, URISyntaxException 	    	{
	    		frequest.addGetParameters(parameter, value);
	    		return this;
	    	}
	    	public NotificationList search() throws IOException
	    	{
	    		HttpMethod http = new HttpMethod("GET",frequest);
	    		Response object = http.execute();
	    		//System.out.println(object.getSMS().getSMSMessages()[0].getSid());
	    		return object.getNotificationList();
	    		
	    	}
	    }
}
