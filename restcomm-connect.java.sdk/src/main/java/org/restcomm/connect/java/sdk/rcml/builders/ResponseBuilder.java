package org.restcomm.connect.java.sdk.rcml.builders;

import org.restcomm.rcml.verbs.Hangup;
import org.restcomm.rcml.verbs.Response;

@SuppressWarnings("all")
public class ResponseBuilder {

	private Response response;

	public ResponseBuilder() {
		response = new Response();
	}

	public Response build() {
		return response;
	}

	public ResponseBuilder say(GenericBuilder builder) {
		return addCommand(builder);
	}
	public ResponseBuilder pause(GenericBuilder builder) {
		return addCommand(builder);
	}
	public ResponseBuilder email(GenericBuilder builder) {
		return addCommand(builder);
	}
	public ResponseBuilder gather(GenericBuilder builder) {
		return addCommand(builder);
	}
	public ResponseBuilder play(GenericBuilder builder) {
		return addCommand(builder);
	}
	public ResponseBuilder sms(GenericBuilder builder) {
		return addCommand(builder);
	}
	public ResponseBuilder redirect(GenericBuilder builder) {
		return addCommand(builder);
	}
	public ResponseBuilder hangup() {
		response.addCommand(new Hangup());
		return this;
	}
	
	private ResponseBuilder addCommand(GenericBuilder builder) {
		response.addCommand(builder.build());
		return this;
	}

}
