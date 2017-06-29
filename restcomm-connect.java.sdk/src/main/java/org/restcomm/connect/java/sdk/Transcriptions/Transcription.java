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
package org.restcomm.connect.java.sdk.Transcriptions;

import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Utilities;
import org.restcomm.connect.java.sdk.http.*;

import org.restcomm.connect.java.sdk.Exceptions.*;

public class Transcription{
	
	static String BASE_URL = Restcomm.COMMON_URL+"Accounts/"+Restcomm.getAuthID()+"/Transcriptions.json/";
	
	static public void SubAccountAccess(String sid)  
	{
		BASE_URL = Restcomm.COMMON_URL+"Accounts/"+sid+"/Transcriptions.json/";
	}
	public static Transcription getTranscription(String sid) 
	{
		Restcomm.sendRequest((new Request(HttpMethod.GET,BASE_URL+sid)));	
		return Utilities.TranscriptionObject(Restcomm.getJSONResponse());
	}
	public static void deleteTranscription(String sid)
	{
		Restcomm.sendRequest((new Request(HttpMethod.DELETE,BASE_URL+sid)));
	}
	/*public static TranscriptionsList getTranscriptionsList()
	{
		return new TranscriptionsList(BASE_URL);
	}*/
	private String sid;

    private String duration;

    private String price;

    private String status;

    private String date_updated;

    private String recording_sid;

    private String date_created;

    private String uri;

    private String transcription_text;

    private String account_sid;

    public String getSid ()
    {
        return sid;
    }

    private void setSid (String sid)
    {
        this.sid = sid;
    }

    public String getDuration ()
    {
        return duration;
    }

    private void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getPrice ()
    {
        return price;
    }

    private void setPrice (String price)
    {
        this.price = price;
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

    public String getRecording_sid ()
    {
        return recording_sid;
    }

    private void setRecording_sid (String recording_sid)
    {
        this.recording_sid = recording_sid;
    }

    public String getDate_created ()
    {
        return date_created;
    }

    private void setDate_created (String date_created)
    {
        this.date_created = date_created;
    }

    public String getUri ()
    {
        return uri;
    }

    private void setUri (String uri)
    {
        this.uri = uri;
    }

    public String getTranscription_text ()
    {
        return transcription_text;
    }

    private void setTranscription_text (String transcription_text)
    {
        this.transcription_text = transcription_text;
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
