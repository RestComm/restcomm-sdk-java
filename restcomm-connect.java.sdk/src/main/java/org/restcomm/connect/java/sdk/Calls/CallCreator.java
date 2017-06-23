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


public class CallCreator {
	
	static String BASE_URL;
	public Request request;
	public CallCreator(final String BASE_URL) {
		
		CallCreator.BASE_URL = BASE_URL;
		request = new Request(HttpMethod.POST,BASE_URL);
	}
	public CallCreator From(String value)
	{
		request.addPostParameters("From", value);
		return this;
	}
	public CallCreator To(String value)
	{
		request.addPostParameters("To", value);
		return this;
	}
	public CallCreator Url(String value)
	{
		request.addPostParameters("Url", value);
		return this;
	}
	public CallCreator Method(String value)
	{
		request.addPostParameters("Method", value);
		return this;
	}
	public CallCreator FallbackUrl(String value)
	{
		request.addPostParameters("FallbackUrl", value);
		return this;
	}
	public CallCreator FallbackMethod(String value)
	{
		request.addPostParameters("FallbackMethod", value);
		return this;
	}
	public CallCreator statusCallbackEvent(String value)
	{
		request.addPostParameters("statusCallbackEvent", value);
		return this;
	}
	public CallCreator statusCallback(String value)
	{
		request.addPostParameters("statusCallback", value);
		return this;
	}
	public CallCreator statusCallbackMethod(String value)
	{
		request.addPostParameters("statusCallbackMethod", value);
		return this;
	}
	public CallCreator Timeout(String value)
	{
		request.addPostParameters("Timeout", value);
		return this;
	}
	public Call makeCall() 
	{
		Restcomm.sendRequest(request);	
		return Utilities.CallObject(Restcomm.getJSONResponse());
	}

}
