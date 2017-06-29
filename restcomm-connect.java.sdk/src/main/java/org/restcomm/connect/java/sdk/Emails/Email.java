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
package org.restcomm.connect.java.sdk.Emails;

import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Utilities;
import org.restcomm.connect.java.sdk.http.*;

import org.restcomm.connect.java.sdk.Exceptions.*;

public class Email{
	
	static String BASE_URL = Restcomm.COMMON_URL+"Accounts/"+Restcomm.getAuthID()+"/Email/Messages.json/";
	
	static public void SubAccountAccess(String sid)  
	{
		BASE_URL = Restcomm.COMMON_URL+"Accounts/"+sid+"/Email/Messages.json/";
	}
	
	public static EmailCreator newEmail()
	{
		return new EmailCreator(BASE_URL);
	}

    private String to;

    private String body;

    private String subject;

    private String from;

    private String date_sent;

    private String account_sid;

    public String getTo ()
    {
        return to;
    }

    private void setTo (String to)
    {
        this.to = to;
    }

    public String getBody ()
    {
        return body;
    }

    private void setBody (String body)
    {
        this.body = body;
    }

    public String getSubject ()
    {
        return subject;
    }

    private void setSubject (String subject)
    {
        this.subject = subject;
    }

    public String getFrom ()
    {
        return from;
    }

    private void setFrom (String from)
    {
        this.from = from;
    }

    public String getDate_sent ()
    {
        return date_sent;
    }

    private void setDate_sent (String date_sent)
    {
        this.date_sent = date_sent;
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
