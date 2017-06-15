package org.restcomm.connect.java.sdk.Accounts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.restcomm.connect.java.sdk.Restcomm;
import org.apache.http.ParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import org.restcomm.connect.java.sdk.http.*;

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
		Restcomm.sendRequest(new Request(HttpMethod.GET,BASE_URL));
		Type ListType = new TypeToken< ArrayList<SubAccount> >(){}.getType();
		Gson gson = new Gson();
		
		/*List<Resource> founderList = gson.fromJson(a, founderListType);*/
		List = gson.fromJson(Restcomm.getJSONResponse(),ListType);
		//Resource Object = gson.fromJson(a,Resource.class);
	}
	
}
