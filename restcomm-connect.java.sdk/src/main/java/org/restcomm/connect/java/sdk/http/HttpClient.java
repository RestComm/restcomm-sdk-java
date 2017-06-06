package org.restcomm.connect.java.sdk.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.restcomm.connect.java.sdk.Credentials;

public class HttpClient{
	
		private Request request;
		private CloseableHttpClient httpclient;
		private static CloseableHttpResponse response;
		private HttpGet httpget;
		private HttpPut httpput;
		private HttpPost httppost;
		private HttpDelete httpdelete;
		private Response Object;
		private StringReader sr;
		
		public HttpClient(final Request request)
		{
			this.request= request;
		}
		
		
		public void authenticate()
		{
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
	        credsProvider.setCredentials(
	                new AuthScope("cloud.restcomm.com", -1),
	                new UsernamePasswordCredentials(Credentials.getAuthID(),Credentials.getAuthToken()));
	        httpclient = HttpClients.custom()
	                .setDefaultCredentialsProvider(credsProvider)
	                .build();
		}
		
		
		public void connect()
		{
			try {
				
			
				
				if(request.getMethod().toString()=="GET") {
							httpget = new HttpGet(request.getUrl());
							response = httpclient.execute(httpget);
				}
				else if(request.getMethod().toString()=="POST"){
							httppost = new HttpPost(request.getUrl());
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
							response = httpclient.execute(httpdelete);
							
				}
				sr = new StringReader(EntityUtils.toString(response.getEntity()));
				response.close();
				httpclient.close();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void toObjectResponse() throws ParseException, IOException, JAXBException
		{
			Object = new Response();
			
            JAXBContext jaxbContext;
			
				jaxbContext = JAXBContext.newInstance(Response.class);
			
            
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            
            Object = (Response) jaxbUnmarshaller.unmarshal(sr);
            
		}
		
		public void execute() throws JAXBException, ParseException, IOException
		{
			this.authenticate();
			this.connect();
			this.toObjectResponse();	
		}
		public Response getObjectResponse()
		{
			return Object;
		}
		
		
}
