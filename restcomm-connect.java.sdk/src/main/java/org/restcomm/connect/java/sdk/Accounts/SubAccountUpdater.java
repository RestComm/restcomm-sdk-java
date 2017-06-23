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
package org.restcomm.connect.java.sdk.Accounts;

import org.apache.http.ProtocolException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.http.*;

import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Accounts.SubAccount;
import org.restcomm.connect.java.sdk.Accounts.SubAccountUpdater;
import org.restcomm.connect.java.sdk.Utilities;

public class SubAccountUpdater {
	private String BASE_URL;
	private Request request;
	SubAccountUpdater()
	{
	}
	public SubAccountUpdater(final String BASE_URL) {
		request = new Request(HttpMethod.PUT,BASE_URL);
	}
	public SubAccountUpdater newRole(String value)
	{
		request.addPostParameters("Role", value);
		return this;
	}
	public SubAccountUpdater newEmail(String value)
	{
		request.addPostParameters("EmailAddress", value);
		return this;
	}
	public SubAccountUpdater newPassword(String value)
	{
		request.addPostParameters("Password", value);
		return this;
	}
	public SubAccountUpdater newStatus(String value)
	{
		request.addPostParameters("Status", value);
		return this;
	}
	public SubAccountUpdater newFriendlyName(String value)
	{
		request.addPostParameters("FriendlyName", value);
		return this;
	}
	public SubAccount modify()
	{
		Restcomm.sendRequest(request);
		return (SubAccount)Utilities.AccountObject(Restcomm.getJSONResponse());
	}

}
