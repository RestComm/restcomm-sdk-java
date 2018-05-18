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
package org.restcomm.connect.java.sdk.Emails;
import org.restcomm.connect.java.sdk.http.*;
import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Utilities;


public class EmailCreator {
	
	static String BASE_URL;
	public Request request;
	public EmailCreator(final String BASE_URL) {
		
		EmailCreator.BASE_URL = BASE_URL;
		request = new Request(HttpMethod.POST,BASE_URL);
	}
	public EmailCreator From(String value)
	{
		request.addPostParameters("From", value);
		return this;
	}
	public EmailCreator To(String value)
	{
		request.addPostParameters("To", value);
		return this;
	}
	public EmailCreator Body(String value)
	{
		request.addPostParameters("Body", value);
		return this;
	}
	public EmailCreator Subject(String value)
	{
		request.addPostParameters("Subject", value);
		return this;
	}
	public EmailCreator BCC(String value)
	{
		request.addPostParameters("BCC", value);
		return this;
	}
	public EmailCreator CC(String value)
	{
		request.addPostParameters("CC", value);
		return this;
	}
	public Email sendEmail() 
	{
		Restcomm.sendRequest(request);	
		return Utilities.EmailObject(Restcomm.getJSONResponse());
	}
	
}
