
package org.restcomm.connect.java.sdk;

import com.google.gson.Gson;

import org.restcomm.connect.java.sdk.Accounts.Account;

public class Utilities {

	public static Account AccountObject(String jsonResponse) {
		
				Gson gson = new Gson();
				return gson.fromJson(jsonResponse,Account.class);
	}
	
	

}
