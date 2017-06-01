package Default.Calls;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.ParseException;

import Default.Constants;
import Default.Credentials;
import Default.FilteredCallList;
import http.HttpClient;
import http.HttpMethod;
import http.Request;
import http.Response;


@XmlRootElement(name = "Calls")
public class CallList {
	private static String BASE_URL = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Calls";
	
	
	private String previouspageuri;
	private String uri;
	private String nextpageuri;
	private String firstpageuri;
	private String lastpageuri;
	
	@XmlElement(name = "Call")
	private ArrayList<Call> List;
	public String geturi()
    {
        return uri;
    }
	@XmlAttribute(name="uri")
    public void seturi (String List)
    {
        this.uri = List;
    }
	public String getfirstpageuri()
    {
        return firstpageuri;
    }
	@XmlAttribute(name="firstpageuri")
    public void setfirstpageuri (String List)
    {
        this.firstpageuri = List;
    }
	public String getnextpageuri()
    {
        return nextpageuri;
    }
	@XmlAttribute(name="nextpageuri")
    public void setnextpageuri (String List)
    {
        this.nextpageuri = List;
    }
	public String getlastpageuri()
    {
        return lastpageuri;
    }
	@XmlAttribute(name="lastpageuri")
    public void setlastpageuri (String List)
    {
        this.lastpageuri = List;
    }
    public String getpreviouspageuri()
    {
        return previouspageuri;
    }
	@XmlAttribute(name="previouspageuri")
    public void setpreviouspageuri (String List)
    {
        this.previouspageuri = List;
    }
	
	
	
    public ArrayList<Call> getList()
    {
        return List;
    }

    public void setList (ArrayList<Call> List)
    {
        this.List = List;
    }

    public CallList getCallsList() throws IOException, ParseException, JAXBException
    {
    	HttpClient client = new HttpClient(new Request(HttpMethod.GET,BASE_URL));
		client.execute();
		return client.getObjectResponse().getCallList();
	}
    public static FilteredCallList getFilteredCallsList()
    {
    	return new FilteredCallList(BASE_URL);
    }
       
    
    
    
    //Paging wasnt handled by you
}
