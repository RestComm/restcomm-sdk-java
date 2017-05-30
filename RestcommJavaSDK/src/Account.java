
import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Account")
public class Account extends SubAccount{
	
	private static String BASE_URL = Constants.COMMON_URL+"Accounts/";
	
	@SuppressWarnings("unused")
	private HttpMethod http;
	protected Request request;
	
	public static Account getAccount() throws IOException
	{
		Request request = new Request(BASE_URL+Credentials.getAuthID().replaceAll("@", "%40"));
		HttpMethod http = new HttpMethod("GET",request);
		Response object = http.execute();
		return object.getAccount();
	}

	public modAccountDetails modifyAccountDetails()
	{
		request= new Request(BASE_URL+"/"+this.getSid());
		modAccountDetails b = new modAccountDetails();
		b.request=this.request;
		return b;
		
	}
	class modAccountDetails{
		Request request;
		public modAccountDetails newPassword(String value)
		{
			request.addPostParameters("Password", value);
			return this;
		}
		public modAccountDetails newStatus(String value)
		{
			request.addPostParameters("Status", value);
			return this;
		}
		public modAccountDetails newFriendlyName(String value)
		{
			request.addPostParameters("FriendlyName", value);
			return this;
		}
		public void modify() throws IOException
		{
			http = new HttpMethod("PUT",this.request);
			
		}
	}
	
	
	
	
	
	
	
	
}
