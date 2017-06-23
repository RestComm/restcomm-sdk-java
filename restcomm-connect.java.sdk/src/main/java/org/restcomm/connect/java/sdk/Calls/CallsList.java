package org.restcomm.connect.java.sdk.Calls;

import java.io.IOException;
import org.restcomm.connect.java.sdk.http.*;

import org.restcomm.connect.java.sdk.Restcomm;
import org.apache.http.ProtocolException;
import org.restcomm.connect.java.sdk.Exceptions.*;
import org.apache.http.ParseException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import org.restcomm.connect.java.sdk.ListUtil;
import org.apache.http.ParseException;
import com.google.gson.annotations.SerializedName;

public class CallsList extends ListUtil {
	
	private static String BASE_URL = Restcomm.COMMON_URL+"Accounts/"+Restcomm.getAuthID()+"/Calls.json/";
	private static Request request;
	
	static public void SubAccountAccess(String sid)  //To access the Applications connected to SubAccounts
	{
		BASE_URL = Restcomm.COMMON_URL+"Accounts/"+sid+"/Calls.json/";
	}
	private List<Call> calls;
	

	public Call get(int index)
	{
		return calls.get(index);
	}
	public int size()
	{
		return calls.size();
	}
    private void setList (List<Call> Calls)
    {
        this.calls = Calls;
    }
    public static CallsList getCallsList() 
	{
		request = new Request(HttpMethod.GET,BASE_URL);	
		Restcomm.sendRequest(request);
		Gson gson = new Gson();
		//System.out.println(Restcomm.getJSONResponse());
		request = new Request(HttpMethod.GET,BASE_URL);	
		return gson.fromJson(Restcomm.getJSONResponse(),CallsList.class);
	}
    
    public CallsList addFilterParam(String param,String value) throws Exception
    {
    	request.addGetParameters(param,value);
    	return this;
    }
    public CallsList Filter()
    {
    	Restcomm.sendRequest(this.request);
		Gson gson = new Gson();
		request = new Request(HttpMethod.GET,BASE_URL);	
		//System.out.println(Restcomm.getJSONResponse());
		return gson.fromJson(Restcomm.getJSONResponse(),CallsList.class);
    }
    
}
