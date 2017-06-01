package Default;


import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

import http.Request;
import http.Response;
@XmlRootElement(name = "Client")
public class Client extends Resource {

	public String BASE_URL= "https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/Clients";
	private HttpMethod http;
	protected Request request;
	public Client getClient(String sid) throws IOException
	{
		request = new Request(BASE_URL+"/"+sid);
		http = new HttpMethod("GET",request);
		Response a = http.execute();
		return a.getClient();
	}
	public addParamClient addClient(String login,String password)
	{
		request = new Request(BASE_URL);		
		request.addPostParameters("Login", login);
		request.addPostParameters("Password", password);
		addParamClient b = new addParamClient();
		b.request=this.request;
		return b;
		
	}
	class addParamClient extends Client{
		
		public addParamClient addParameters(String paramter,String value)
		{
			request.addPostParameters(paramter, value);
			return this;
		}
		public void create() throws IOException
		{
			http = new HttpMethod("POST",this.request);
			http.execute();
		}
	}
	public modParamClient modifyClient()
	{
		request= new Request(BASE_URL+"/"+this.getSid());
		modParamClient b = new modParamClient();
		b.request=this.request;
		return b;
		
	}
	class modParamClient extends Client{
		public modParamClient modifyParameter(String parameter,String value)
		{
			request.addPostParameters(parameter, value);
			return this;
		}
		public void modify() throws IOException
		{
			http = new HttpMethod("PUT",this.request);
			http.execute();
		}
	}
	

}
