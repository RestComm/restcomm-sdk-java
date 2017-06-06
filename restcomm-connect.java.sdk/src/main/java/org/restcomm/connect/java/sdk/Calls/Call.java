package org.restcomm.connect.java.sdk.Calls;
import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.Credentials;
import org.restcomm.connect.java.sdk.Resource;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;

@XmlRootElement(name = "Call")
public class Call extends Resource{
	
	static String BASE_URL = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Calls/";
	
	static public void SubAccountAccess(String sid)     //To access the Applications connected to SubAccounts
	{
		BASE_URL = Constants.COMMON_URL+"Accounts/"+sid+"/Applications/";
	}
	
	//Fetch a Call with a given Sid
	public static Call getCall(String sid) throws IOException, ParseException, JAXBException
	{
		HttpClient client = new HttpClient(new Request(HttpMethod.GET,BASE_URL+sid));
		client.execute();
		return client.getObjectResponse().getCall();
	}
	public static CallCreator newCall() throws IOException
	{
		return new CallCreator(BASE_URL);
	}
	public static CallModifer modifyLiveCall(String sid)
	{
		return new CallModifer(sid,BASE_URL);
		
	}
	public CallModifer modifyLiveCall()
	{
		return new CallModifer(this.getSid(),BASE_URL);
	}
	
	
	//public modCall modifyLiveCall()
	//{
		
	//}
	//Modifying Live Calls
	
}
