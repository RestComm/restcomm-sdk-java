import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Call")
public class Call extends Resource{
	
	public static String BASE_URL = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Calls/";
	static public void SubAccountAccess(String sid)     //To access the Calls connected to SubAccounts
	{
		BASE_URL = Constants.COMMON_URL+"Accounts/"+sid+"/Applications/";
	}
	
	public static Call getCall(String sid) throws IOException
	{
		Request request = new Request(BASE_URL+sid);
		HttpMethod http = new HttpMethod("GET",request);
		Response object = http.execute();
		return object.getCall();
	}
	public nCall newCall(String from,String to,String url) throws IOException
	{
		Request request = new Request(BASE_URL);
		request.addPostParameters("From",from.replace("+","%2B"));
		request.addPostParameters("To",to.replace("+","%2B"));
		request.addPostParameters("Url",url);
		nCall b = new nCall();
		b.request=request;
		return b;
		
	}
	static class nCall 
	{
		public Request request;
		public nCall Method(String value)
		{
			request.addPostParameters("Method", value);
			return this;
		}
		public nCall FallbackUrl(String value)
		{
			request.addPostParameters("FallbackUrl", value);
			return this;
		}
		public nCall FallbackMethod(String value)
		{
			request.addPostParameters("FallbackMethod", value);
			return this;
		}
		public nCall statusCallbackEvent(String value)
		{
			request.addPostParameters("statusCallbackEvent", value);
			return this;
		}
		public nCall statusCallback(String value)
		{
			request.addPostParameters("statusCallback", value);
			return this;
		}
		public nCall statusCallbackMethod(String value)
		{
			request.addPostParameters("statusCallbackMethod", value);
			return this;
		}
		public nCall Timeout(String value)
		{
			request.addPostParameters("Timeout", value);
			return this;
		}
		public void makeCall() throws IOException
		{
			HttpMethod http = new HttpMethod("POST",request);
			http.execute();
		}
	}
	
	//Modifying Live Calls
	
}
