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


public class CallModifier {
		
	private Request request;
	private static String BASE_URL;
	public CallModifier(final String BASE_URL) {
		CallModifier.BASE_URL = BASE_URL;
		request = new Request(HttpMethod.POST,BASE_URL);
	}
	public CallModifier newUrl(String value)
	{
		request.addPostParameters("Url", value);
		return this;
	}
	public CallModifier newMethod(String value)
	{
		request.addPostParameters("Method", value);
		return this;
	}
	public CallModifier newStatus(String value)
	{
		request.addPostParameters("Status", value);
		return this;
	}
	public CallModifier newMute(String value)
	{
		request.addPostParameters("Mute", value);
		return this;
	}
	public CallModifier statusCallback(String value)
	{
		request.addPostParameters("statusCallback", value);
		return this;
	}
	public CallModifier statusCallbackMethod(String value)
	{
		request.addPostParameters("statusCallbackMethod", value);
		return this;
	}
	public CallModifier FallbackUrl(String value)
	{
		request.addPostParameters("FallbackUrl", value);
		return this;
	}
	public CallModifier FallbackMethod(String value)
	{
		request.addPostParameters("FallbackMethod", value);
		return this;
	}
	public CallModifier MoveConnectedCallLeg(String value)
	{
		request.addPostParameters("MoveConnectedCallLeg", value);
		return this;
	}
	
	public Call modify() 
	{
		Restcomm.sendRequest(request);	
		return Utilities.CallObject(Restcomm.getJSONResponse());
	}
}
