import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
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

public class HttpMethod {

		String method;
		Request request;
		String username=Credentials.getUsername();
		String password=Credentials.getPassword();
		CloseableHttpClient httpclient;
		public HttpMethod(String method,Request request)
		{
			this.method=method;
			this.request=request;
		}
		public Response execute() throws IOException
		{
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
	        credsProvider.setCredentials(
	                new AuthScope("cloud.restcomm.com", -1),
	                new UsernamePasswordCredentials(username,password));
	        httpclient = HttpClients.custom()
	                .setDefaultCredentialsProvider(credsProvider)
	                .build();
	        Response Object = null;
			if(method.equals("GET"))
			{
				Object = new Response();
				HttpGet httpget = new HttpGet(request.getUrl());
				System.out.println("Executing request " + httpget.getRequestLine());
	            CloseableHttpResponse response = httpclient.execute(httpget);
	            //Object.setHttpStatusCode(response.getStatusLine().getStatusCode());
	            System.out.println(response.getStatusLine());
	            StringReader sr = new StringReader(EntityUtils.toString(response.getEntity()));
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
				httpclient.close();
				return Object;
			}
			else if(method.equals("POST"))
			{
					Object = new Response();
					
					HttpPost httppost = new HttpPost(request.getUrl());
					httppost.setEntity(new UrlEncodedFormEntity(request.nameValuePairs));
					System.out.println("Executing request " + httppost.getRequestLine());
					CloseableHttpResponse response = httpclient.execute(httppost);
					System.out.println(response.getStatusLine());
					
					StringReader sr = new StringReader(EntityUtils.toString(response.getEntity()));
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
					httpclient.close();
					return Object;
			}
			else if(method.equals("PUT"))
			{
				Object = new Response();
				HttpPut httpput = new HttpPut(request.getUrl());
				httpput.setEntity(new UrlEncodedFormEntity(request.nameValuePairs));
				System.out.println("Executing request " + httpput.getRequestLine());
	            CloseableHttpResponse response = httpclient.execute(httpput);
	            System.out.println(response.getStatusLine());
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
	            StringReader sr = new StringReader(EntityUtils.toString(response.getEntity()));
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
				httpclient.close();
				return Object;
			}
			else if(method.equals("DELETE"))
			{
				Object = new Response();
				HttpDelete httpdelete = new HttpDelete(request.getUrl());
				System.out.println("Executing request " + httpdelete.getRequestLine());
	            CloseableHttpResponse response = httpclient.execute(httpdelete);
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
	            
				httpclient.close();
				return Object;
				
			}
			
			return Object;
		}
		
		
		
		
}
