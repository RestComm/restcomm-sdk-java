package org.restcomm.connect.java.sdk.EmailMessages;

import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.Credentials;
import org.restcomm.connect.java.sdk.Resource;

public class EmailMessage extends Resource{
	
	static String BASE_URL = Constants.COMMON_URL+"Accounts/"+Credentials.getAuthID()+"/Email/Messages";
	
	static public void SubAccountAccess(String sid)     //To access the Applications connected to SubAccounts
	{
		BASE_URL = Constants.COMMON_URL+"Accounts/"+sid+"/Applications/";
	}
	
	public static EmailCreator sendNewEmail()
	{
		return new EmailCreator(BASE_URL);
	}
}
