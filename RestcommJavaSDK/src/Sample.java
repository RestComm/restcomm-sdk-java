import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

public class Sample {
	
	public static void main(String args[]) throws ClientProtocolException, IOException, URISyntaxException
	{
		Credentials.setAuthID("ACee72087d9be1903b60fc31e8aad3a8d3");
		Credentials.setAuthToken("3358dfd6439e39dd1d908f64a9fa1e21");
		Constants.COMMON_URL = "https://cloud.restcomm.com/restcomm/2012-04-24";
		
		//Fetching the Default Account Associated with the login credentials specified
		Account account = Account.getAccount();
	
		
		//Modifying the details of the Default Account
		account.modifyAccountDetails().newFriendlyName("Paul").newStatus("pool").newPassword("poland").modify();
		
		
	}

}