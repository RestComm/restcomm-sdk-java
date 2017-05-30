import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "Gateway")
public class Gateway extends Resource{

	public String BASE_URL="https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/Management/Gateways";
	private HttpMethod http;
	Request request;
	public Gateway getGateway(String sid) throws IOException
	{
		request = new Request(BASE_URL+"/"+sid);
		http = new HttpMethod("GET",request);
		Response a = http.execute();
		return a.getGateway();
	}
	public addParamGateway addGateway(String username,String password,String proxy,String ttl,String register) throws IOException
	{
		request = new Request(BASE_URL);
		request.addPostParameters("UserName",username);
		request.addPostParameters("Password",password);
		request.addPostParameters("Proxy",proxy);
		request.addPostParameters("Register",register);
		request.addPostParameters("TTL", ttl);
		addParamGateway b = new addParamGateway();
		b.request=this.request;
		return b;
		
	}
	class addParamGateway extends Gateway{
		
		public addParamGateway addParameters(String paramter,String value)
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
	public modParamGateway modifyGateway()
	{
		request= new Request(BASE_URL+"/"+this.getSid());
		modParamGateway b = new modParamGateway();
		b.request=this.request;
		return b;
		
	}
	class modParamGateway extends Gateway{
		public modParamGateway modifyParameter(String parameter,String value)
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
	public void deleteGateway(String sid) throws IOException
	{
		request = new Request(BASE_URL+"/"+sid);
		http = new HttpMethod("DELETE",request);
		Response a = http.execute();
	}

}
