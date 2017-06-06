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

@XmlRootElement(name = "Accounts")
public class SubAccountList {
	private static String BASE_URL = Constants.COMMON_URL+"Accounts";
	@XmlElement(name = "Account")
	private ArrayList<SubAccount> List;
	public ArrayList<SubAccount> getList() {
		return List;
	}

	public SubAccount get(int index)
	{
		return List.get(index);
	}
	public void setList(ArrayList<SubAccount> list) {
		List = list;
	}
	 public SubAccountList getSubAccountList() throws IOException, ParseException, JAXBException
	    {
			HttpClient client = new HttpClient(new Request(HttpMethod.GET,BASE_URL));
			client.execute();
			return client.getObjectResponse().getSubAccountList();
		}
	
}
