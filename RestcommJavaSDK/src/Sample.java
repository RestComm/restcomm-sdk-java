import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

public class Sample {
	
	public static void main(String args[]) throws ClientProtocolException, IOException, URISyntaxException
	{
		//Set your AuthId and AuthToken
		Credentials.setAuthID("");
		Credentials.setAuthToken("");
		
		//Im keeping it to the default cloud Url but you can change it to anything that you require
		Constants.COMMON_URL = "https://cloud.restcomm.com/restcomm/2012-04-24";
		
		//Fetching the Default Account Associated with the login credentials specified
		Account account = Account.getAccount();
	
		
		//Modifying the details of the Default Account
		account.modifyAccountDetails().newFriendlyName("Paul").newStatus("").newPassword("poland").modify();
		
		
	}

}