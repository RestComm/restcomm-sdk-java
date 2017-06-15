package org.restcomm.connect.java.sdk;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;
import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.http.Request;


public class Restcomm {

	private static String username;
	private static String password;
	private static String authID;
	public static String COMMON_URL="https://cloud.restcomm.com/restcomm/2012-04-24/";
	private static HttpClient httpclient;
	private static String JSONResponse;
	private static int StatusCode;
	
	public static void setCommonUrl(final String COMMON_URL)
	{
		Restcomm.COMMON_URL=COMMON_URL;
	}
    public static void init(final String username, final String password) {
    	Restcomm.setUsername(username);
    	Restcomm.setPassword(password);
    }
    public static void sendRequest(final Request request) 
    {
    	Restcomm.refresh();
    	
    	JSONResponse = httpclient.execute(request);
    	StatusCode = httpclient.getStatusCode();
    }
    private static void refresh() {
		httpclient = new HttpClient();
		JSONResponse = null;
		
	}
	public static String getJSONResponse()
    {
    	return JSONResponse;
    }
	private static void setUsername(final String username) {
    	Restcomm.username = username;
    }
    private static void setPassword(final String password) {
    	Restcomm.password = password;
    }
    private static void setAccountSid(final String accountSid) {
        Restcomm.authID = accountSid;
    }
	public static String getAuthID() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	
	public static void invalidate()
	{
		username = null;password=null;
		COMMON_URL=null;authID=null;
		httpclient=null;JSONResponse=null;
	}
	public static int getStatusCode()
	{
		return StatusCode;
	}

}