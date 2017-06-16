
/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.restcomm.connect.java.sdk.Accounts;
import org.restcomm.connect.java.sdk.Exceptions.*;


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
import org.apache.http.ProtocolException;
public class SubAccount{

	private static String BASE_URL = Restcomm.COMMON_URL+"Accounts.json/";
	
	public static SubAccount getSubAccount(final String sid)
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
	public void deleteSubAccount() 
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

	protected void setSid (String sid)
    {
        this.sid = sid;
    }

    public String getStatus ()
    {
        return status;
    }

    protected void setStatus (String status)
    {
        this.status = status;
    }

    public String getDate_updated ()
    {
        return date_updated;
    }

    protected void setDate_updated (String date_updated)
    {
        this.date_updated = date_updated;
    }

    public String getRole ()
    {
        return role;
    }

    protected void setRole (String role)
    {
        this.role = role;
    }

    public String getAuth_token ()
    {
        return auth_token;
    }

    protected void setAuth_token (String auth_token)
    {
        this.auth_token = auth_token;
    }

    public String getDate_created ()
    {
        return date_created;
    }

    protected void setDate_created (String date_created)
    {
        this.date_created = date_created;
    }

    public String getFriendly_name ()
    {
        return friendly_name;
    }

    protected void setFriendly_name (String friendly_name)
    {
        this.friendly_name = friendly_name;
    }

    public String getType ()
    {
        return type;
    }

    protected void setType (String type)
    {
        this.type = type;
    }
    public String getUri ()
    {
        return uri;
    }

    protected void setUri (String uri)
    {
        this.uri = uri;
    }

    public String getEmail_address()
    {
        return email_address;
    }

    protected void setEmail_address (String email_address)
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
	
}