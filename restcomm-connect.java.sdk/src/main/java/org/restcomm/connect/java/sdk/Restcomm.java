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
package org.restcomm.connect.java.sdk;

import org.apache.http.ProtocolException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;
import org.restcomm.connect.java.sdk.http.HttpClient;
import org.restcomm.connect.java.sdk.http.Request;

import org.restcomm.connect.java.sdk.Exceptions.*;


public class Restcomm {

	private static String username;
	private static String password;
	private static String authID;
	public static String COMMON_URL="https://cloud.restcomm.com/restcomm/2012-04-24/";
	private static HttpClient httpclient;
	private static String JSONResponse;
	private static int StatusCode;
	
	public static void setCommonUrl(final String COMMON_URL)
	{
		Restcomm.COMMON_URL=COMMON_URL;
	}
    public static void init(final String username, final String password) {
    	Restcomm.setUsername(username);
    	Restcomm.setPassword(password);
    }
    public static void sendRequest(final Request request)
    {
    	Restcomm.refresh();
    	
    	JSONResponse = httpclient.execute(request);
    	StatusCode = httpclient.getStatusCode();
    }
    private static void refresh() {
		httpclient = new HttpClient();
		JSONResponse = null;
		
	}
	public static String getJSONResponse()
    {
    	return JSONResponse;
    }
	private static void setUsername(final String username) {
    	Restcomm.username = username;
    }
    private static void setPassword(final String password) {
    	Restcomm.password = password;
    }
    private static void setAccountSid(final String accountSid) {
        Restcomm.authID = accountSid;
    }
	public static String getAuthID() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	
	public static void invalidate()
	{
		username = null;password=null;
		COMMON_URL=null;authID=null;
		httpclient=null;JSONResponse=null;
	}
	public static int getStatusCode()
	{
		return StatusCode;
	}

}