package org.restcomm.connect.java.sdk.Accounts;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;

public class SubAccountList {
	
	private String BASE_URL;

	private List<SubAccount> List;
	
	public SubAccount get(int index)
	{
		return List.get(index);
	}
	public int size()
	{
		return List.size();
	}
	public void setList(List<SubAccount> list) {
		List = list;
	}
	public SubAccountList(final String BASE_URL)
	{
		this.BASE_URL = BASE_URL;
		HttpClient client = new HttpClient(new Request(HttpMethod.GET,BASE_URL));
		String a = client.execute();
		
		Restcomm.sendRequest(new Request(HttpMethod.GET,BASE_URL));
		Type ListType = new TypeToken< ArrayList<SubAccount> >(){}.getType();
		Gson gson = new Gson();
		
		/*List<Resource> founderList = gson.fromJson(a, founderListType);*/
		List = gson.fromJson(Restcomm.getJSONResponse,ListType);
		//Resource Object = gson.fromJson(a,Resource.class);
	}
	
}
