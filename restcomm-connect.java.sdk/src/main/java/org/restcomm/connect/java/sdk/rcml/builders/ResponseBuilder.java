package org.restcomm.connect.java.sdk.rcml.builders;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.restcomm.connect.java.sdk.rcml.verbs.Hangup;
import org.restcomm.connect.java.sdk.rcml.verbs.Response;

@SuppressWarnings("all")
public class ResponseBuilder {

	private Response response;

	public ResponseBuilder() {
		response = new Response();
	}

	public Response build() {
		return response;
	}

	public String toXML(){
		try {
			StringWriter sw = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(response, sw);
			return sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
