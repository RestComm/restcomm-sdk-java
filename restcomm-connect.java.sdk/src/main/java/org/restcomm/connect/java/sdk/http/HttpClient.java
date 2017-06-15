package org.restcomm.connect.java.sdk.http;
import org.restcomm.connect.java.sdk.Restcomm;

import org.restcomm.connect.java.sdk.ExceptionHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



public class HttpClient{
	
		
		private CloseableHttpClient httpclient;
		private CloseableHttpResponse response;
		private HttpGet httpget;
		private HttpPut httpput;
		private HttpPost httppost;
		private HttpDelete httpdelete;	
		private byte[] credentials;
		private int StatusCode;
		
		public void authenticate()
		{
			this.credentials = Base64.encodeBase64((Restcomm.getAuthID() + ":" + Restcomm.getPassword()).getBytes(StandardCharsets.UTF_8));
			this.httpclient =  HttpClientBuilder.create().build();
		}
		
		public String connect(final Request request)
		{
			String responseString=null;
			try {
				
			
				
					if(request.getMethod().toString()=="GET"){ 
							httpget = new HttpGet(request.getUrl());
							httpget.setHeader("Authorization", "Basic " + new String( this.credentials, StandardCharsets.UTF_8));
							response = httpclient.execute(httpget);
					}
					else if(request.getMethod().toString()=="POST"){
							httppost = new HttpPost(request.getUrl());
							httppost.setHeader("Authorization", "Basic " + new String( credentials, StandardCharsets.UTF_8));
							httppost.setEntity(new UrlEncodedFormEntity(request.PostParameters));
							response = httpclient.execute(httppost);
							
							/*BufferedReader rd = new BufferedReader(new InputStreamReader(
				                    response.getEntity().getContent()));

				            String line = "";
				            while ((line = rd.readLine()) != null) {
				                System.out.println(line);
				                if (line.startsWith("Auth=")) {
				                    String key = line.substring(5);
				                    // do something with the key
				                }

				            }*/
					}
					else if(request.getMethod().toString()=="PUT"){ 
							httpput = new HttpPut(request.getUrl());
							httpput.setHeader("Authorization", "Basic " + new String( credentials, StandardCharsets.UTF_8));
							httpput.setEntity(new UrlEncodedFormEntity(request.PostParameters));
							response = httpclient.execute(httpput);
							/*BufferedReader rd = new BufferedReader(new InputStreamReader(
		                    response.getEntity().getContent()));

		            String line = "";
		            while ((line = rd.readLine()) != null) {
		                System.out.println(line);
		                if (line.startsWith("Auth=")) {
		                    String key = line.substring(5);
		                    // do something with the key
		                }

		            }*/
					}
					else if(request.getMethod().toString()=="DELETE"){
							httpdelete = new HttpDelete(request.getUrl());
							httpdelete.setHeader("Authorization", "Basic " + new String( credentials, StandardCharsets.UTF_8));
							response = httpclient.execute(httpdelete);		
					}	
				
					
				ExceptionHandler Handle = new ExceptionHandler(response);
				this.StatusCode=response.getStatusLine().getStatusCode();
				
				responseString = EntityUtils.toString(response.getEntity());
				response.close();
				httpclient.close();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return responseString;
		}
		/*public String toObjectResponse() throws ParseException, IOException
		{
			
			Gson gson = new Gson();
			
			System.out.println(responseString);
			Response Object = gson.fromJson(responseString,Response.class);
			
			
			
			
			
			Object = new Response();
			
            JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(Response.class);
			
            
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            
            Object = (Response) jaxbUnmarshaller.unmarshal(sr);
            
            
			}
			 catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		*/
		public String execute(Request request)
		{
			this.authenticate();
			return this.connect(request);
		}
		/*public Resource toObject()
		{
			Gson gson = new Gson();
			Resource Object = gson.fromJson(responseString,Resource.class);
			return Object;
		}*/		
		public int getStatusCode()
		{
			return this.StatusCode;
		}
}
		


