
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

import org.restcomm.connect.java.sdk.http.*;

import com.google.gson.Gson;
import org.restcomm.connect.java.sdk.Exceptions.*;
import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Accounts.Account;
import org.restcomm.connect.java.sdk.Accounts.AccountUpdater;

import org.restcomm.connect.java.sdk.Utilities;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.ParseException;
import org.apache.http.ProtocolException;

public class Account extends SubAccount{
	
	private static String BASE_URL = Restcomm.COMMON_URL+"Accounts.json/";
	
	public static Account getAccount()
	{
		Restcomm.sendRequest((new Request(HttpMethod.GET,BASE_URL+Restcomm.getAuthID().replaceAll("@", "%40"))));	
		return 	Utilities.AccountObject(Restcomm.getJSONResponse());
	}
	
	public AccountUpdater modifyAccountDetails()
	{
		return new AccountUpdater(BASE_URL);
	}
	public static AccountUpdater modifyDefaultAccount() 
	{
		return new AccountUpdater(BASE_URL);
	}
	public SubAccountList getSubAccountList() 
	{
		return new SubAccountList(BASE_URL);
	}
	public static SubAccountList SubAccountList()
	{
		return new SubAccountList(BASE_URL);
	}
	public static SubAccountCreator createSubAccount()
	{
		return new SubAccountCreator(BASE_URL);
	}
	
}
