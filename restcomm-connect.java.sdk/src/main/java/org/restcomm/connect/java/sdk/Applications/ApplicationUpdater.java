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
package org.restcomm.connect.java.sdk.Applications;
import org.apache.http.ProtocolException;
import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Utilities;

import org.restcomm.connect.java.sdk.Applications.ApplicationUpdater;
import org.restcomm.connect.java.sdk.http.*;

public class ApplicationUpdater {
	
	static String BASE_URL;
	public Request request;
	public ApplicationUpdater(String BASE_URL) {
		request = new Request(HttpMethod.PUT,BASE_URL);
	}
	public ApplicationUpdater newFriendlyName(String value)
	{
		request.addPostParameters("FriendlyName", value);
		return this;
	}
	public ApplicationUpdater newRcmlUrl(String rcmlurl)
	{
		request.addPostParameters("RcmlUrl", rcmlurl);
		return this;
	}
	public ApplicationUpdater newKind(String kind)
	{
		request.addPostParameters("Kind", kind);
		return this;
	}
	public ApplicationUpdater HasVoiceCallerIdLookup(String a)
	{
		request.addPostParameters("HasVoiceCallerIdLookup", a);
		return this;
	}
	public Application update()
	{
		Restcomm.sendRequest(request);	
		return Utilities.ApplicationObject(Restcomm.getJSONResponse());
	}

}
