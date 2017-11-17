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

/**
 * @author Kleber Damasco kleber.damasco@hashtech.com.br
 */
@XmlRootElement(name = "Response")
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("all")
public class Response {
	
	@XmlElements({
		@XmlElement(name = "Say", type = Say.class),	
		@XmlElement(name = "Record", type = Record.class),	
		@XmlElement(name = "Email", type = Email.class),	
		@XmlElement(name = "Gather", type = Gather.class),	
		@XmlElement(name = "Hangup", type = Hangup.class),	
		@XmlElement(name = "Pause", type = Pause.class),
		@XmlElement(name = "Play", type = Play.class),
		@XmlElement(name = "Sms", type = Sms.class),
		@XmlElement(name = "Redirect", type = Redirect.class),
		@XmlElement(name = "Reject", type = Reject.class),
		@XmlElement(name = "Fax", type = Fax.class),
		@XmlElement(name = "UssdCollect", type = UssdCollect.class),
		@XmlElement(name = "UssdMessage", type = UssdMessage.class),
		@XmlElement(name = "Language", type = String.class),
		@XmlElement(name = "Geolocation", type = Geolocation.class),
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
	public Response record(GenericBuilder builder) {
		return addCommand(builder);
	}
	public Response pause(GenericBuilder builder) {
		return addCommand(builder);
	}
	public Response reject(GenericBuilder builder) {
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
	public Response fax(Fax fax) {
		commands.add(fax);
		return this;
	}
	public Response language(String language) {
		commands.add(language);
		return this;
	}
	public Response ussdCollect(UssdCollect language) {
		commands.add(language);
		return this;
	}
	public Response ussdMessage(UssdMessage language) {
		commands.add(language);
		return this;
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
