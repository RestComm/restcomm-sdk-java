import java.io.IOException;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Application")
public class Application extends Resource{
	
	static String BASE_URL = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Applications/";
	Request request;
	static HttpMethod http;
	static public void SubAccountAccess(String sid)     //To access the Applications connected to SubAccounts
	{
		BASE_URL = Constants.COMMON_URL+"Accounts/"+sid+"/Applications/";
	}
	public static Application getApplication(String sid) throws IOException
	{
		Request request = new Request(BASE_URL+sid);
		HttpMethod http = new HttpMethod("GET",request);
		Response object = http.execute();
		return object.getApplication();
	}
	static class newApplication 
	{
		public Request request;
		public newApplication ApiVersion(String apiversion)
		{
			request.addPostParameters("ApiVersion", apiversion);
			return this;
		}
		public newApplication RcmlUrl(String rcmlurl)
		{
			request.addPostParameters("RcmlUrl", rcmlurl);
			return this;
		}
		public newApplication Kind(String kind)
		{
			request.addPostParameters("Kind", kind);
			return this;
		}
		public newApplication HasVoiceCallerIdLookup(String a)
		{
			request.addPostParameters("HasVoiceCallerIdLookup", a);
			return this;
		}
		public void add() throws IOException
		{
			http = new HttpMethod("POST",request);
			http.execute();
		}
	}
	public static newApplication addApplication(String friendlyName) throws IOException
	{
		Request request = new Request(BASE_URL);
		request.addPostParameters("FriendlyName", friendlyName);
		newApplication b = new newApplication();
		b.request=request;
		if(request.getUrl()==null) System.out.println("pol");
		return b;
	}
	
	public modApplication modifyApplication(String sid) throws IOException
	{
		request = new Request(BASE_URL+sid);
		modApplication b = new modApplication();
		b.request=this.request;
		return b;
	}
	class modApplication 
	{
		Request request;
		public modApplication newApiVersion(String apiversion)
		{
			request.addPostParameters("ApiVersion", apiversion);
			return this;
		}
		public modApplication newRcmlUrl(String rcmlurl)
		{
			request.addPostParameters("RcmlUrl", rcmlurl);
			return this;
		}
		public modApplication newKind(String kind)
		{
			request.addPostParameters("Kind", kind);
			return this;
		}
		public modApplication HasVoiceCallerIdLookup(String a)
		{
			request.addPostParameters("HasVoiceCallerIdLookup", a);
			return this;
		}
		public void modify() throws IOException
		{
			http = new HttpMethod("PUT",request);
			http.execute();
		}
	}
	public void delete() throws IOException
	{
		Request request = new Request(BASE_URL+this.getSid());
		HttpMethod http = new HttpMethod("DELETE",request);
		http.execute();
	}
	public static void deleteApplication(String sid) throws IOException
	{
		Request request = new Request(BASE_URL+sid);
		HttpMethod http = new HttpMethod("DELETE",request);
		http.execute();
	}

	
	
	
	
	
	
}
