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

import java.io.IOException;
import org.restcomm.connect.java.sdk.http.*;

import org.restcomm.connect.java.sdk.Restcomm;
import org.apache.http.ProtocolException;
import org.restcomm.connect.java.sdk.Exceptions.*;
import org.apache.http.ParseException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import org.restcomm.connect.java.sdk.ListUtil;
import org.apache.http.ParseException;
import com.google.gson.annotations.SerializedName;

public class TranscriptionList extends ListUtil {
	
	private static String BASE_URL = Restcomm.COMMON_URL+"Accounts/"+Restcomm.getAuthID()+"/Transcriptions.json";
	private static Request request;
	
	static public void SubAccountAccess(String sid)  //To access the Applications connected to SubAccounts
	{
		BASE_URL = Restcomm.COMMON_URL+"Accounts/"+sid+"/Transcriptions.json";
	}
	private List<Transcription> transcriptions;
	
	public Transcription get(int index)
	{
		return transcriptions.get(index);
	}
	public int size()
	{
		return transcriptions.size();
	}
    private void setList (List<Transcription> transcriptions)
    {
        this.transcriptions = transcriptions;
    }
    public static TranscriptionList getList() 
	{
		request = new Request(HttpMethod.GET,BASE_URL);	
		Restcomm.sendRequest(request);
		Gson gson = new Gson();
		
		request = new Request(HttpMethod.GET,BASE_URL);	
		return gson.fromJson(Restcomm.getJSONResponse(),TranscriptionList.class);
	}
    public static FilteredTranscriptionList getFilteredList()
    {
    	
    	return new FilteredTranscriptionList(BASE_URL);
    }
    
}
