package org.restcomm.connect.java.sdk.rcml.verbs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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

	public void addCommand(Object command) {
		commands.add(command);
	}
	
	@Override
	public String toString() {
		return "Response [commands=" + commands + "]";
	}

}
