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
package org.restcomm.connect.java.sdk.http;
import java.net.MalformedURLException;
//import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;


import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

public class Request {

	private String Url;
	private HttpMethod method;
	//public Map<String,String> QueryParameters;
	//public Map<String,String> PostParameters;
	public ArrayList<NameValuePair> QueryParameters; 
	public ArrayList<NameValuePair> PostParameters;
	
	public Request(HttpMethod method,String Url)
	{
		this.Url= Url;
		this.method = method;
		this.QueryParameters= new ArrayList<NameValuePair>();
		this.PostParameters= new ArrayList<NameValuePair>();
		
		try {
			this.Url = new URL(new URIBuilder(Url).build().toString()).toString();
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
	}
	public HttpMethod getMethod()
	{
		return method;
	}
	public void addGetParameters(String a,String b)
	{
		
		try{
			URIBuilder urib = new URIBuilder(Url);
			urib.addParameter(a,b);
			urib.build();
			Url = new URL(urib.toString()).toString();
		   }
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
	public void addPostParameters(String a,String b)
	{
		PostParameters.add(new BasicNameValuePair(a,
                b));
	}	
	public String getUrl()
	{
		return Url;
	}
	
}
