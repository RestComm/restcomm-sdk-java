
import java.net.MalformedURLException;
//import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;


import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

public class Request {

	public String Url;
	//public Map<String,String> QueryParameters;
	//public Map<String,String> PostParameters;
	public ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	
	public Request(String Url)
	{
		this.Url= Url;
		//QueryParameters=new HashMap<String,String>();
		//PostParameters= new HashMap<String,String>();
	}
	public void addGetParameters(String a,String b) throws MalformedURLException, URISyntaxException
	{
		
			URIBuilder urib = new URIBuilder(Url);
			urib.addParameter(a,b);
			urib.build();
			Url = new URL(urib.toString()).toString();
			System.out.println(Url);
	}
	public void addPostParameters(String a,String b)
	{
		nameValuePairs.add(new BasicNameValuePair(a,
                b));
	}	
	public String getUrl()
	{
		return Url;
	}
	
}
