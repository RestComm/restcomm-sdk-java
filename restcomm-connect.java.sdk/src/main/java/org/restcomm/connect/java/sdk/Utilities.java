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

import com.google.gson.Gson;

import org.restcomm.connect.java.sdk.Applications.Application;

import org.restcomm.connect.java.sdk.Accounts.Account;

public class Utilities {

	public static Account AccountObject(String jsonResponse) {
		
				Gson gson = new Gson();
				return gson.fromJson(jsonResponse,Account.class);
	}
	public static Application ApplicationObject(String jsonResponse) {
		
		Gson gson = new Gson();
		return gson.fromJson(jsonResponse,Application.class);
	}
}
