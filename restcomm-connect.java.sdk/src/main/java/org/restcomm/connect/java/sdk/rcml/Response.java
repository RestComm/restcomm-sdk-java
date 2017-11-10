package org.restcomm.connect.java.sdk.rcml;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("all")
public class Response {
	
	@XmlElements({
		@XmlElement(name = "say", type = Say.class),	
		@XmlElement(name = "record", type = Record.class),	
		@XmlElement(name = "email", type = Email.class),	
		@XmlElement(name = "gather", type = Gather.class),	
		@XmlElement(name = "Hangup", type = Hangup.class),	
		@XmlElement(name = "Pause", type = Pause.class),
		@XmlElement(name = "Play", type = Play.class),
		@XmlElement(name = "Sms", type = Sms.class),
		@XmlElement(name = "Redirect", type = Redirect.class),
	})
	private List<Object> commands;
	
	public List<Object> getCommands() {
		return commands;
	}
	
	public Response() {
		commands = new ArrayList<Object>(0);
	}

	public Response build(){
		return this;
	}
	
	public String toXML(){
		try {
			StringWriter sw = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(this, sw);
			return sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public Response say(GenericBuilder builder) {
		return addCommand(builder);
	}
	public Response pause(GenericBuilder builder) {
		return addCommand(builder);
	}
	public Response email(GenericBuilder builder) {
		return addCommand(builder);
	}
	public Response gather(GenericBuilder builder) {
		return addCommand(builder);
	}
	public Response play(GenericBuilder builder) {
		return addCommand(builder);
	}
	public Response sms(GenericBuilder builder) {
		return addCommand(builder);
	}
	public Response redirect(GenericBuilder builder) {
		return addCommand(builder);
	}

	private Response addCommand(GenericBuilder builder) {
		commands.add(builder.build());
		return this;
	}
	public Response hangup() {
		commands.add(new Hangup());
		return this;
	}


}
