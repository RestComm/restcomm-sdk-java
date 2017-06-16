
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
import org.restcomm.connect.java.sdk.Exceptions.*;

import javax.naming.InsufficientResourcesException;
import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;

import org.restcomm.connect.java.sdk.Utilities;
import org.restcomm.connect.java.sdk.http.*;

import org.restcomm.connect.java.sdk.Restcomm;
public class SubAccountCreator {


	private Request request;
	private Boolean role= false;
	private Boolean password= false;
	private Boolean email= false;
	SubAccountCreator(final String BASE_URL)
	{
		request = new Request(HttpMethod.POST,BASE_URL);
	}
	public SubAccountCreator Role(String value)
	{
		role =true;
		request.addPostParameters("Role", value);
		return this;
	}
	public SubAccountCreator Email(String value)
	{
		email=true;
		request.addPostParameters("EmailAddress", value);
		return this;
	}
	public SubAccountCreator Password(String value)
	{
		password=true;
		request.addPostParameters("Password", value);
		return this;
	}
	public SubAccountCreator Status(String value)
	{
		request.addPostParameters("Status", value);
		return this;
	}
	public SubAccountCreator FriendlyName(String value)
	{
		request.addPostParameters("FriendlyName", value);
		return this;
	}
	public SubAccount create() 
	{
		try
		{
			if(email && password && role)
			{
				Restcomm.sendRequest(request);
				//System.out.println(Restcomm.getJSONResponse());
				return (SubAccount)Utilities.AccountObject(Restcomm.getJSONResponse());
			}
			else throw new InsufficientResourcesException("You need to specify Email,Password and Role for this request");
		}
		catch(InsufficientResourcesException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		return null;

	}
}
