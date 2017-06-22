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
package org.restcomm.connect.java.sdk.Clients;

import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Utilities;
import org.restcomm.connect.java.sdk.http.*;

import org.restcomm.connect.java.sdk.Exceptions.*;

public class Client{
	
	static String BASE_URL = Restcomm.COMMON_URL+"Accounts/"+Restcomm.getAuthID()+"/Clients.json/";
	
	static public void SubAccountAccess(String sid)  
	{
		BASE_URL = Restcomm.COMMON_URL+"Accounts/"+sid+"/Clients.json/";
	}
	public static Client getClient(String sid) 
	{
		Restcomm.sendRequest((new Request(HttpMethod.GET,BASE_URL+sid)));	
		return Utilities.ClientObject(Restcomm.getJSONResponse());
	}
	public static ClientCreator createClient() 
	{
		return new ClientCreator(BASE_URL);
	}
	
	public static ClientUpdater updateClient(String sid)
	{
		return new ClientUpdater(BASE_URL+sid);
	}
	public ClientUpdater updateClient()
	{
		return updateClient(this.getSid());
	}
	public void deleteApplication() 
	{
		deleteApplication(this.getSid());
	}
	public static void deleteApplication(String sid) 
	{
		Restcomm.sendRequest((new Request(HttpMethod.DELETE,BASE_URL+sid)));
	}
	public static ClientList getClientList()
	{
		return new ClientList(BASE_URL);
	}
	
	private String sid;

    private String status;

    private String voice_fallback_method;

    private String date_updated;

    private String login;

    private String date_created;

    private String friendly_name;

    private String uri;

    private String password;

    private String api_version;

    private String voice_method;

    private String account_sid;

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

    public String getVoice_fallback_method ()
    {
        return voice_fallback_method;
    }

    private void setVoice_fallback_method (String voice_fallback_method)
    {
        this.voice_fallback_method = voice_fallback_method;
    }

    public String getDate_updated ()
    {
        return date_updated;
    }

    private void setDate_updated (String date_updated)
    {
        this.date_updated = date_updated;
    }

    public String getLogin ()
    {
        return login;
    }

    private void setLogin (String login)
    {
        this.login = login;
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

    public String getUri ()
    {
        return uri;
    }

    private void setUri (String uri)
    {
        this.uri = uri;
    }

    public String getPassword ()
    {
        return password;
    }

    private void setPassword (String password)
    {
        this.password = password;
    }

    public String getApi_version ()
    {
        return api_version;
    }

    private void setApi_version (String api_version)
    {
        this.api_version = api_version;
    }

    public String getVoice_method ()
    {
        return voice_method;
    }

    private void setVoice_method (String voice_method)
    {
        this.voice_method = voice_method;
    }

    public String getAccount_sid ()
    {
        return account_sid;
    }

    private void setAccount_sid (String account_sid)
    {
        this.account_sid = account_sid;
    }

}
