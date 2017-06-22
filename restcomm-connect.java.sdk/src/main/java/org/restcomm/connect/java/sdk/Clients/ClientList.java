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
import org.restcomm.connect.java.sdk.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.restcomm.connect.java.sdk.Restcomm;
import org.apache.http.ProtocolException;
import org.restcomm.connect.java.sdk.Exceptions.*;
import org.apache.http.ParseException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

public class ClientList {
	
	private String BASE_URL;

	private List<Client> List;
	
	public Client get(int index)
	{
		return List.get(index);
	}
	public int size()
	{
		return List.size();
	}
	public void setList(List<Client> list) {
		List = list;
	}
	public ClientList(final String BASE_URL) 
	{
		this.BASE_URL = BASE_URL;
		Restcomm.sendRequest(new Request(HttpMethod.GET,BASE_URL));
		Type ListType = new TypeToken< ArrayList<Client> >(){}.getType();
		Gson gson = new Gson();
		
		List = gson.fromJson(Restcomm.getJSONResponse(),ListType);
		
	}
}	
