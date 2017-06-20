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
import java.util.ArrayList;
import java.util.List;
import org.restcomm.connect.java.sdk.ListUtil;
import org.apache.http.ParseException;


public class CallsList extends ListUtil {
	
	private static String BASE_URL;// = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Calls";
	private Request request;
	private List<Call> List;

	public Call get(int index)
	{
		return List.get(index);
	}
	public int size()
	{
		return List.size();
	}
    private void setList (List<Call> List)
    {
        this.List = List;
    }
    public CallsList(final String BASE_URL) 
	{
		this.BASE_URL = BASE_URL;
		this.request = new Request(HttpMethod.GET,BASE_URL);
		
		Restcomm.sendRequest(new Request(HttpMethod.GET,BASE_URL));
		Type ListType = new TypeToken< ArrayList<Call> >(){}.getType();
		Gson gson = new Gson();
		List = gson.fromJson(Restcomm.getJSONResponse(),ListType);
	}
    public CallsList addFilterParam(String param,String value) throws Exception
    {
    	request.addGetParameters(param,value);
    	return this;
    }
    public void Filter()
    {

		Restcomm.sendRequest(this.request);
		Type ListType = new TypeToken< ArrayList<Call> >(){}.getType();
		Gson gson = new Gson();
		List = gson.fromJson(Restcomm.getJSONResponse(),ListType);
    }
    
}
