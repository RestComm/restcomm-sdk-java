package Default;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import http.Request;
import http.Response;

@XmlRootElement(name = "Clients")
public class ClientsList {

	public String BASE_URL= "https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/Clients";
	@XmlElement(name = "Client")
	private ArrayList<Client> List;
	
	public ArrayList<Client> getList()
    {
        return List;
    }

    public void setClientsList (ArrayList<Client> List)
    {
        this.List = List;
    }
    public ClientsList getNewList() throws IOException
    {
		Request request = new Request(BASE_URL);
		HttpMethod http = new HttpMethod("GET",request);
		Response object = http.execute();
		//System.out.println(object.getSMS().getSMSMessages()[0].getSid());
		this.List=object.getClients().getList();
		return this;
	}
    /*public FilteredClientsList getFilteredList()
    {
    	return new FilteredClientsList();
    }
    public class FilteredClientsList extends ClientsList{
    	Request frequest = new Request(BASE_URL);
    	
    	public FilteredClientsList addSearchParameters(String parameter,String value) throws MalformedURLException, URISyntaxException
    	{
    		frequest.addGetParameters(parameter, value);
    		return this;
    	}
    	public ClientsList search() throws IOException
    	{
    		HttpMethod http = new HttpMethod("GET",frequest);
    		http.authentication(Credentials.authID,Credentials.authToken);
    		Response object = http.execute();
    		//System.out.println(object.getSMS().getSMSMessages()[0].getSid());
    		return object.getClients();
    		
    	}
    }*/

}
