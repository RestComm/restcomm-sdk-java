package org.restcomm.connect.java.sdk;

import org.restcomm.connect.java.sdk.Exceptions.*;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.client.methods.CloseableHttpResponse;

public class ExceptionHandler {

	 private CloseableHttpResponse response;
	 public ExceptionHandler(final CloseableHttpResponse response)
	 {
		 this.response = response;
		 int StatusCode;
		 StatusCode = response.getStatusLine().getStatusCode();
		 
			try {
 
					if(StatusCode==401) throw new AuthenticationException("The Credentials Provided Are Incorrect");
					if(StatusCode==404) throw new ResourceNotFoundException("The Requested Resource Is Not Available");

			
				} catch (AuthenticationException e) {
				
					e.printStackTrace();
				} catch (ResourceNotFoundException e) {
					
					e.printStackTrace();
				}
	 
	 
	 
	 }
	 
	 
	
	
	
}
