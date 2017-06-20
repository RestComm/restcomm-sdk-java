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
package org.restcomm.connect.java.sdk.Calls;

import org.restcomm.connect.java.sdk.http.*;
import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Utilities;

public class Call {
	
	static String BASE_URL = Restcomm.COMMON_URL+"Accounts/"+Restcomm.getAuthID()+"/Calls.json/";
	
	static public void SubAccountAccess(String sid)     
	{
		BASE_URL = Restcomm.COMMON_URL+"Accounts/"+sid+"/Calls.json/";
	}
	
	public static Call getCall(String sid)
	{
		Restcomm.sendRequest((new Request(HttpMethod.GET,BASE_URL+sid)));	
		return Utilities.CallObject(Restcomm.getJSONResponse());
	}
	
	public static CallCreator newCall()
	{
		return new CallCreator(BASE_URL);
	}
	
	public static CallModifier modifyLiveCall(String sid)
	{
		return new CallModifier(BASE_URL+sid);
	}
	
	public CallModifier modifyLiveCall()
	{
		return new CallModifier(BASE_URL+this.getSid());
	}
	
	public static CallsList getCallsList()
	{
		return new CallsList(BASE_URL);
	}
	

	 	private String to;

	    private String sid;

	    private String status;

	    private String direction;

	    private String InstanceId;

	    private String date_created;

	    private String from;

	    private String uri;

	    private String api_version;

	    private String account_sid;

	    private String date_updated;

	    private String start_time;

	    private String price_unit;

	    private String caller_name;

	    public String getTo ()
	    {
	        return to;
	    }

	    private void setTo (String to)
	    {
	        this.to = to;
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

	    public String getDirection ()
	    {
	        return direction;
	    }

	    private void setDirection (String direction)
	    {
	        this.direction = direction;
	    }

	    public String getInstanceId ()
	    {
	        return InstanceId;
	    }

	    private void setInstanceId (String InstanceId)
	    {
	        this.InstanceId = InstanceId;
	    }

	    public String getDate_created ()
	    {
	        return date_created;
	    }

	    private void setDate_created (String date_created)
	    {
	        this.date_created = date_created;
	    }

	    public String getFrom ()
	    {
	        return from;
	    }

	    private void setFrom (String from)
	    {
	        this.from = from;
	    }

	    public String getUri ()
	    {
	        return uri;
	    }

	    private void setUri (String uri)
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

	    public String getDate_updated ()
	    {
	        return date_updated;
	    }

	    private void setDate_updated (String date_updated)
	    {
	        this.date_updated = date_updated;
	    }

	    public String getStart_time ()
	    {
	        return start_time;
	    }

	    private void setStart_time (String start_time)
	    {
	        this.start_time = start_time;
	    }

	    public String getPrice_unit ()
	    {
	        return price_unit;
	    }

	    private void setPrice_unit (String price_unit)
	    {
	        this.price_unit = price_unit;
	    }
	    
	    public String getCaller_name ()
	    {
	        return caller_name;
	    }

	    private void setCaller_name (String caller_name)
	    {
	        this.caller_name = caller_name;
	    }
}

