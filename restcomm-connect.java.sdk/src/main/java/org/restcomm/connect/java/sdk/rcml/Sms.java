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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author Kleber Damasco kleber.damasco@hashtech.com.br
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Sms implements GenericBuilder<Sms> {

	@XmlAttribute
	protected String to;

	@XmlAttribute
	protected String from;

	@XmlAttribute
	protected String action;

	@XmlAttribute
	protected String method;

	@XmlAttribute
	protected String statusCallback;
	
	@XmlValue
	protected String text;
	
	public Sms() {
	}

	public String getTo() {
		return to;
	}

	public String getFrom() {
		return from;
	}

	public String getAction() {
		return action;
	}

	public String getMethod() {
		return method;
	}

	public String getStatusCallback() {
		return statusCallback;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "Email [to=" + to + ", cc=" + action + ", Bcc=" + method + ", from=" + from + ", Subject=" + statusCallback + ", text="
				+ text + "]";
	}
	
	public Sms to(String to) {
		this.to = to;
		return this;
	}
	
	public Sms from(String from) {
		this.from = from;
		return this;
	}
	
	public Sms action(String action) {
		this.action = action;
		return this;
	}

	public Sms method(String method) {
		this.method = method;
		return this;
	}

	public Sms statusCallback(String statusCallback) {
		this.statusCallback = statusCallback;
		return this;
	}
	
	public Sms text(String text) {
		this.text = text;
		return this;
	}
	
	public Sms build() {
		return this;
	}
	
}
