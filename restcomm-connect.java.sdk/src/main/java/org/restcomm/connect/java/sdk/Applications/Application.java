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
package org.restcomm.connect.java.sdk.Applications;

import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Utilities;
import org.restcomm.connect.java.sdk.http.*;

import org.restcomm.connect.java.sdk.Exceptions.*;

public class Application{
	
	static String BASE_URL = Restcomm.COMMON_URL+"Accounts/"+Restcomm.getAuthID()+"/Applications.json/";
	
	static public void SubAccountAccess(String sid)  //To access the Applications connected to SubAccounts
	{
		BASE_URL = Restcomm.COMMON_URL+"Accounts/"+sid+"/Applications.json/";
	}
	public static Application getApplication(String sid) 
	{
		Restcomm.sendRequest((new Request(HttpMethod.GET,BASE_URL+sid)));	
		return Utilities.ApplicationObject(Restcomm.getJSONResponse());
	}
	public static ApplicationCreator addApplication() 
	{
		return new ApplicationCreator(BASE_URL);
	}
	public static ApplicationUpdater updateApplication(String sid)
	{
		return new ApplicationUpdater(BASE_URL+sid);
	}
	public ApplicationUpdater updateApplication()
	{
		return updateApplication(this.getSid());
	}
	public void deleteApplication() 
	{
		deleteApplication(this.getSid());
	}
	public static void deleteApplication(String sid) 
	{
		Restcomm.sendRequest((new Request(HttpMethod.DELETE,BASE_URL+sid)));
	}
	public static ApplicationList getApplicationList()
	{
		return new ApplicationList(BASE_URL);
	}

	private String sid;

    private String voice_caller_id_lookup;

    private String date_updated;

    private String date_created;

    private String friendly_name;

    private String uri;

    private String api_version;

    private String account_sid;

    public String getSid ()
    {
        return sid;
    }

    private void setSid (String sid)
    {
        this.sid = sid;
    }

    public String getVoice_caller_id_lookup ()
    {
        return voice_caller_id_lookup;
    }

    private void setVoice_caller_id_lookup (String voice_caller_id_lookup)
    {
        this.voice_caller_id_lookup = voice_caller_id_lookup;
    }

    public String getDate_updated ()
    {
        return date_updated;
    }

    private void setDate_updated (String date_updated)
    {
        this.date_updated = date_updated;
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

    private void setUri(String uri)
    {
        this.uri = uri;
    }

    public String getApi_version ()
    {
        return api_version;
    }

    private void setApi_version (String api_version)
    {
        this.api_version = api_version;
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
