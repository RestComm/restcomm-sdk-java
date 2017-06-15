package org.restcomm.connect.java.sdk.Accounts;


import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.http.HttpMethod;
import org.restcomm.connect.java.sdk.http.Request;

import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Accounts.SubAccount;
import org.restcomm.connect.java.sdk.Accounts.SubAccountCreator;
import org.restcomm.connect.java.sdk.Accounts.SubAccountUpdater;
import org.restcomm.connect.java.sdk.Utilities;

public class SubAccount{

	private static String BASE_URL = Restcomm.COMMON_URL+"Accounts.json/";
	
	public static SubAccount getSubAccount(final String sid) throws IOException, JAXBException
	{
		Restcomm.sendRequest(new Request(HttpMethod.GET,BASE_URL+sid));	
		return Utilities.AccountObject(Restcomm.getJSONResponse());
	}
	
	public SubAccountUpdater modifySubAccountDetails()
	{
		return new SubAccountUpdater(this.BASE_URL+this.getSid());
	}
	public static SubAccountUpdater modifySubAccount(final String sid)
	{
		return new SubAccountUpdater(BASE_URL+sid);
	}
	public void deleteSubAccount() throws ParseException, IOException, JAXBException
	{
		Restcomm.sendRequest(new Request(HttpMethod.DELETE,BASE_URL+this.getSid()));
		return;
	}
	public static void deleteSubAccount(final String sid)
	{
		Restcomm.sendRequest(new Request(HttpMethod.DELETE,BASE_URL+sid));
	}
	
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

    private void setDate_updated (String date_updated)
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

    public String getEmail_address()
    {
        return email_address;
    }

    private void setEmail_address (String email_address)
    {
        this.email_address = email_address;
    }

    protected String sid;
	protected String status;
	protected String date_updated;
	protected String role;
	protected String auth_token;
	protected String date_created;
	protected String friendly_name;
	protected String type;
	protected String uri;
	protected String email_address;
	
	@Override
	public String toString()
	{
	return "SubAccount [sid = "+sid+", status = "+status+", date_updated = "+date_updated+", role = "+role+", auth_token = "+auth_token+", date_created = "+date_created+", friendly_name = "+friendly_name+", type = "+type+", subresource_uris = \", uri = "+uri+", email_address = "+email_address+"]";
	}
}