package Default;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import http.Request;
import http.Response;

@XmlRootElement(name="Gateways")
public class GatewayList {
	
	public String BASE_URL="https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/Management/Gateways";
	 @XmlElement(name="Gateway")
	 public ArrayList<Gateway> List;
	 
	 public ArrayList<Gateway> getList ()
	    {
	        return List;
	    }
	 public Gateway get(int index)
	 {
		 return List.get(index);
	 }
	    public void setList (ArrayList<Gateway> List)
	    {
	        this.List = List;
	    }
	    public GatewayList getNewList() throws IOException
	    {
			Request request = new Request(BASE_URL);
			HttpMethod http = new HttpMethod("GET",request);
			Response object = http.execute();
			//System.out.println(object.getSMS().getSMSMessages()[0].getSid());
			//System.out.println(object.getGatewayList().getList());
			this.List=object.getGatewayList().getList();
			return this;
		}
}
