package org.restcomm.connect.java.sdk.Accounts;

import org.restcomm.connect.java.sdk.http.*;

import com.google.gson.Gson;

import Default.Restcomm;
import Default.Accounts.Account;
import Default.Accounts.AccountUpdater;
import http.HttpMethod;
import http.Request;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.Constants;
import org.restcomm.connect.java.sdk.Credentials;


public class Account extends SubAccount{
	
	private static String BASE_URL = Constants.COMMON_URL+"Accounts.json/";
	
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
	
	private String sid;

    private String status;

    private String date_updated;

    private String role;

    private String auth_token;

    private String date_created;

    private String friendly_name;

    private String type;

    private String uri;

    private String email_address;

    public String getSid ()
    {
        return sid;
    }

    private void setSid (String sid)
    {
        this.sid = sid;
    }

    public String getStatus ()
    {
        return status;
    }

    private void setStatus (String status)
    {
        this.status = status;
    }

    public String getDate_updated ()
    {
        return date_updated;
    }

    privatevoid setDate_updated (String date_updated)
    {
        this.date_updated = date_updated;
    }

    public String getRole ()
    {
        return role;
    }

    private void setRole (String role)
    {
        this.role = role;
    }

    public String getAuth_token ()
    {
        return auth_token;
    }

    private void setAuth_token (String auth_token)
    {
        this.auth_token = auth_token;
    }

    public String getDate_created ()
    {
        return date_created;
    }

    private void setDate_created (String date_created)
    {
        this.date_created = date_created;
    }

    public String getFriendly_name ()
    {
        return friendly_name;
    }

    private void setFriendly_name (String friendly_name)
    {
        this.friendly_name = friendly_name;
    }

    public String getType ()
    {
        return type;
    }

    private void setType (String type)
    {
        this.type = type;
    }
    public String getUri ()
    {
        return uri;
    }

    private void setUri (String uri)
    {
        this.uri = uri;
    }

    public String getEmail_address ()
    {
        return email_address;
    }

    private void setEmail_address (String email_address)
    {
        this.email_address = email_address;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sid = "+sid+", status = "+status+", date_updated = "+date_updated+", role = "+role+", auth_token = "+auth_token+", date_created = "+date_created+", friendly_name = "+friendly_name+", type = "+type+", subresource_uris = \", uri = "+uri+", email_address = "+email_address+"]";
    }
	
}
