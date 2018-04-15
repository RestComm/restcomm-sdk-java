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
package org.restcomm.connect.java.sdk.Conferences;

import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Utilities;
import org.restcomm.connect.java.sdk.http.*;

import org.restcomm.connect.java.sdk.Exceptions.*;

public class Participant{
		
	private String BASE_URL = Restcomm.COMMON_URL+"Accounts/"+Restcomm.getAuthID()+"/Conferences/";
	
	public Participant Mute(String value)
	{
		Request request =  new Request(HttpMethod.POST,BASE_URL+this.getConference_sid()+"/Participants/"+this.getSid());
		request.addPostParameters("Mute",value);
		Restcomm.sendRequest(request);
		return Utilities.ParticipantObject(Restcomm.getJSONResponse());
	}
	
		private String account_sid;

	    private String hold;

	    private String muted;

	    private String start_conference_on_enter;

	    private String uri;

	    private String sid;

	    private String date_created;

	    private String conference_sid;

	    private String date_updated;

	    private String end_conference_on_enter;

	    public String getAccount_Sid ()
	    {
	        return account_sid;
	    }

	    private void setAccount_sid (String AccountSid)
	    {
	        this.account_sid = AccountSid;
	    }

	    public String getHold ()
	    {
	        return hold;
	    }

	    private void setHold (String Hold)
	    {
	        this.hold = Hold;
	    }

	    public String getMuted ()
	    {
	        return muted;
	    }

	    private void setMuted (String Muted)
	    {
	        this.muted = Muted;
	    }

	    public String getStart_conference_on_enter ()
	    {
	        return start_conference_on_enter;
	    }

	    private void setStart_conference_on_enter (String StartConferenceOnEnter)
	    {
	        this.start_conference_on_enter = StartConferenceOnEnter;
	    }

	    public String getUri ()
	    {
	        return uri;
	    }

	    private void setUri (String Uri)
	    {
	        this.uri = Uri;
	    }

	    public String getSid ()
	    {
	        return sid;
	    }

	    private void setSid (String Sid)
	    {
	        this.sid = Sid;
	    }

	    public String getDate_created ()
	    {
	        return date_created;
	    }

	    private void setDate_created (String DateCreated)
	    {
	        this.date_created = DateCreated;
	    }

	    public String getConference_sid ()
	    {
	        return conference_sid;
	    }

	    private void setConference_sid (String ConferenceSid)
	    {
	        this.conference_sid = ConferenceSid;
	    }

	    public String getDate_updated ()
	    {
	        return date_updated;
	    }

	    private void setDate_updated (String DateUpdated)
	    {
	        this.date_updated = DateUpdated;
	    }

	    public String getEnd_conference_on_enter ()
	    {
	        return end_conference_on_enter;
	    }

	    private void setEnd_conference_on_enter (String EndConferenceOnEnter)
	    {
	        this.end_conference_on_enter = EndConferenceOnEnter;
	    }
}
