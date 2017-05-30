

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Account")

public class SubAccount extends Resource{
	
	private static String BASE_URL = Constants.COMMON_URL+"Accounts/";
	protected Request request;
	public static SubAccount getSubAccount(String emailid,String password) throws IOException
	{	
		Request request = new Request(BASE_URL+Credentials.getAuthID().replaceAll("@", "%40"));
		HttpMethod http = new HttpMethod("GET",request);
		Response object = http.execute();
		return (SubAccount) object.getAccount();
	}
	public static void addSubAccount(String friendlyName,String emailAddress,String password) throws IOException
	{
		Request request = new Request(BASE_URL);
		request.addPostParameters("FriendlyName", friendlyName);
		request.addPostParameters("EmailAddress", emailAddress);
		request.addPostParameters("Password", password);
		HttpMethod http = new HttpMethod("POST",request);
		http.execute();
	}
	public void closeSubAccount() throws IOException
	{
		Request request = new Request(BASE_URL+this.getSid());
		request.addPostParameters("Status", "closed");
		HttpMethod http = new HttpMethod("POST",request);
		http.execute();
		
	}
	public static void closeSubAccount(String sid) throws IOException
	{
		Request request = new Request(BASE_URL+sid);
		request.addPostParameters("Status", "closed");
		HttpMethod http = new HttpMethod("POST",request);
		http.execute();
	}

	public modSubAccountDetails modifySubAccountDetails()
	{
		request= new Request(BASE_URL+"/"+this.getSid());
		modSubAccountDetails b = new modSubAccountDetails();
		b.request=this.request;
		return b;
		
	}
	class modSubAccountDetails{
		private Request request;
		public modSubAccountDetails newPassword(String value)
		{
			request.addPostParameters("Password", value);
			return this;
		}
		public modSubAccountDetails newStatus(String value)
		{
			request.addPostParameters("Status", value);
			return this;
		}
		public modSubAccountDetails newFriendlyName(String value)
		{
			request.addPostParameters("FriendlyName", value);
			return this;
		}
		public modSubAccountDetails newRole(String value)
		{
			request.addPostParameters("Role", value);
			return this;
		}
		public modSubAccountDetails newEmailAddress(String value)
		{
			request.addPostParameters("EmailAddress", value);
			return this;
		}
		public void modify() throws IOException
		{
			HttpMethod http = new HttpMethod("PUT",this.request);
			http.execute();
		}
	}
	
	
	
	
}

