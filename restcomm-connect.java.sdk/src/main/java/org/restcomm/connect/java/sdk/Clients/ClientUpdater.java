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
package org.restcomm.connect.java.sdk.Clients;
import org.apache.http.ProtocolException;
import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Utilities;

import org.restcomm.connect.java.sdk.Clients.ClientUpdater;
import org.restcomm.connect.java.sdk.http.*;

public class ClientUpdater {
	
	static String BASE_URL;
	public Request request;
	public ClientUpdater(String BASE_URL) {
		request = new Request(HttpMethod.PUT,BASE_URL);
	}
	public ClientUpdater newFriendlyName(String value)
	{
		request.addPostParameters("FriendlyName", value);
		return this;
	}
	public ClientUpdater newPassword(String rcmlurl)
	{
		request.addPostParameters("Password", rcmlurl);
		return this;
	}
	public ClientUpdater newStatus(String kind)
	{
		request.addPostParameters("Status",kind);
		return this;
	}
	public ClientUpdater newVoiceUrl(String a)
	{
		request.addPostParameters("VoiceUrl", a);
		return this;
	}
	public ClientUpdater newVoiceMethod(String a)
	{
		request.addPostParameters("VoiceMethod", a);
		return this;
	}public ClientUpdater newVoiceFallbackUrl(String a)
	{
		request.addPostParameters("VoiceFallbackUrl", a);
		return this;
	}public ClientUpdater newVoiceFallbackMethod(String a)
	{
		request.addPostParameters("VoiceFallbackMethod", a);
		return this;
	}public ClientUpdater newVoiceApplicationSid(String a)
	{
		request.addPostParameters("VoiceApplicationSid", a);
		return this;
	}
	public Client update()
	{
		Restcomm.sendRequest(request);	
		return Utilities.ClientObject(Restcomm.getJSONResponse());
	}

}
