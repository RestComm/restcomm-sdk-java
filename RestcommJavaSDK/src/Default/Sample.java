package Default;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBException;

import http.HttpMethod;
import org.apache.http.client.ClientProtocolException;

import Default.Accounts.Account;
import Default.Applications.Application;
import Default.Calls.CallList;
public class Sample {
	
	public static void main(String args[]) throws ClientProtocolException, IOException, URISyntaxException, JAXBException
	{
		//Set your AuthId and AuthToken
		Credentials.setAuthID("ACee72087d9be1903b60fc31e8aad3a8d3");
		Credentials.setAuthToken("3358dfd6439e39dd1d908f64a9fa1e21");
		
		//Im keeping it to the default cloud Url but you can change it to anything that you require
		Constants.COMMON_URL = "https://cloud.restcomm.com/restcomm/2012-04-24/";
		
		
		
		//Fetching the Default Account Associated with the login credentials specified
		//Account account = Account.getAccount();
		CallList a ;
		a = CallList.getFilteredCallsList().PageSize("1").search();
		
		System.out.println(a.getnextpageuri());
	}

}