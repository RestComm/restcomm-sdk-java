package org.restcomm.connect.java.sdk.http;
import java.net.MalformedURLException;
//import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;


import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

public class Request {

	private String Url;
	private HttpMethod method;
	//public Map<String,String> QueryParameters;
	//public Map<String,String> PostParameters;
	public ArrayList<NameValuePair> QueryParameters; 
	public ArrayList<NameValuePair> PostParameters;
	
	public Request(HttpMethod method,String Url)
	{
		this.Url= Url;
		this.method = method;
		this.QueryParameters= new ArrayList<NameValuePair>();
		this.PostParameters= new ArrayList<NameValuePair>();
	}
	public HttpMethod getMethod()
	{
		return method;
	}
	public void addGetParameters(String a,String b) throws MalformedURLException, URISyntaxException
	{
		
			URIBuilder urib = new URIBuilder(Url);
			urib.addParameter(a,b);
			urib.build();
			Url = new URL(urib.toString()).toString();
	}
	public void addPostParameters(String a,String b)
	{
		PostParameters.add(new BasicNameValuePair(a,
                b));
	}	
	public String getUrl()
	{
		return Url;
	}
	
}
