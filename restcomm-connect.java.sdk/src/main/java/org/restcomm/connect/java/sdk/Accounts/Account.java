package org.restcomm.connect.java.sdk.Accounts;

import org.restcomm.connect.java.sdk.http.*;

import com.google.gson.Gson;

import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Accounts.Account;
import org.restcomm.connect.java.sdk.Accounts.AccountUpdater;
import java.io.IOException;
import org.restcomm.connect.java.sdk.Utilities;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.ParseException;


public class Account extends SubAccount{
	
	private static String BASE_URL = Restcomm.COMMON_URL+"Accounts.json/";
	
	public static Account getAccount()
	{
		Restcomm.sendRequest((new Request(HttpMethod.GET,BASE_URL+Restcomm.getAuthID().replaceAll("@", "%40"))));	
		return 	Utilities.AccountObject(Restcomm.getJSONResponse());
	}
	
	public AccountUpdater modifyAccountDetails()
	{
		return new AccountUpdater(BASE_URL);
	}
	public static AccountUpdater modifyDefaultAccount()
	{
		return new AccountUpdater(BASE_URL);
	}
	public SubAccountList getSubAccountList()
	{
		return new SubAccountList(BASE_URL);
	}
	public static SubAccountList SubAccountList()
	{
		return new SubAccountList(BASE_URL);
	}
	public static SubAccountCreator createSubAccount()
	{
		return new SubAccountCreator(BASE_URL);
	}
	
}
