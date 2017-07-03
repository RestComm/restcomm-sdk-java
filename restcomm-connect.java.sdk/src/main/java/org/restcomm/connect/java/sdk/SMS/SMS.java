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
package org.restcomm.connect.java.sdk.SMS;

import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Utilities;
import org.restcomm.connect.java.sdk.http.*;

import org.restcomm.connect.java.sdk.Exceptions.*;

public class SMS{
	
	static String BASE_URL = Restcomm.COMMON_URL+"Accounts/"+Restcomm.getAuthID()+"/SMS/Messages.json/";
	
	static public void SubAccountAccess(String sid)  
	{
		BASE_URL = Restcomm.COMMON_URL+"Accounts/"+sid+"/SMS/Messages.json/";
	}
	public static SMS getSMS(String sid) 
	{
		Restcomm.sendRequest((new Request(HttpMethod.GET,BASE_URL+sid)));	
		return Utilities.SMSObject(Restcomm.getJSONResponse());
	}	
	public static SMSCreator newSMS()
	{
		return new SMSCreator(BASE_URL);
	}
	/*public static SMSList getSMSList()
	{
		return new SMSList(BASE_URL);
	}*/
	 	private String to;

	    private String sid;

	    private String body;

	    private String status;

	    private String direction;

	    private String date_created;

	    private String date_sent;

	    private String from;

	    private String uri;

	    private String api_version;

	    private String account_sid;

	    private String price;

	    private String date_updated;

	    private String price_unit;

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

	    public String getBody ()
	    {
	        return body;
	    }

	    private void setBody (String body)
	    {
	        this.body = body;
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

	    public String getDate_created ()
	    {
	        return date_created;
	    }

	    private void setDate_created (String date_created)
	    {
	        this.date_created = date_created;
	    }

	    public String getDate_sent ()
	    {
	        return date_sent;
	    }

	    private void setDate_sent (String date_sent)
	    {
	        this.date_sent = date_sent;
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

	    public String getPrice ()
	    {
	        return price;
	    }

	    private void setPrice (String price)
	    {
	        this.price = price;
	    }

	    public String getDate_updated ()
	    {
	        return date_updated;
	    }

	    private void setDate_updated (String date_updated)
	    {
	        this.date_updated = date_updated;
	    }

	    public String getPrice_unit ()
	    {
	        return price_unit;
	    }

	    private void setPrice_unit (String price_unit)
	    {
	        this.price_unit = price_unit;
	    }
}
