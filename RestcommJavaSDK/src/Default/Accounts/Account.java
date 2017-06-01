package Default.Accounts;
import http.HttpClient;
import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import Default.Constants;
import Default.Credentials;
import http.HttpMethod;
import http.Request;

@XmlRootElement(name = "Account")
public class Account extends SubAccount{
	
	private static String BASE_URL = Constants.COMMON_URL+"Accounts/";
	
	public static Account getAccount() throws IOException, JAXBException
	{
		HttpClient client = new HttpClient(new Request(HttpMethod.GET,BASE_URL+Credentials.getAuthID().replaceAll("@", "%40")));
		client.execute();
		return client.getObjectResponse().getAccount();
	}

	public AccountUpdater modifyAccountDetails()
	{
		return new AccountUpdater();
	}
	
}
