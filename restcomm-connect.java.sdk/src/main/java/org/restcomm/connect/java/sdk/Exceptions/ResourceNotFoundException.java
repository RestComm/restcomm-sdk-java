package org.restcomm.connect.java.sdk.Exceptions;

import org.apache.http.ProtocolException;

public class ResourceNotFoundException extends ProtocolException{

	
	public ResourceNotFoundException() {
        super();
    }
    public ResourceNotFoundException(final String message) {
        super(message);
    }

    public ResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
	
}
