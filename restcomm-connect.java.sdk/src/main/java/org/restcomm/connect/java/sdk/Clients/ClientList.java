package org.restcomm.connect.java.sdk.Clients;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.Credentials;
import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;

@XmlRootElement(name = "Clients")
public class ClientList {

	public String BASE_URL = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Clients";
	public void SubAccountAccess(String sid)
	{
		BASE_URL = Constants.COMMON_URL+"Accounts/"+sid+"/Clients";
	}
	@XmlElement(name = "Client")
	private ArrayList<Client> List;

	public ArrayList<Client> getList() {
		return List;
	}
	public Client get(int index)
	{
		return List.get(index);
	}
	public void setList(ArrayList<Client> list) {
		List = list;
	}
	
	public ClientList getClientList() throws IOException, ParseException, JAXBException
    {
		
		HttpClient client = new HttpClient(new Request(HttpMethod.GET,BASE_URL));
		client.execute();
		return client.getObjectResponse().getClientList();
	}

}
