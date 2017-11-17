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
public class Email implements GenericBuilder<Email>{

	@XmlAttribute(required = true)
	protected String to;

	@XmlAttribute
	protected String cc;

	@XmlAttribute
	protected String bcc;

	@XmlAttribute(required = true)
	protected String from;

	@XmlAttribute
	protected String subject;
	
	@XmlValue
	protected String text;
	
	public Email() {
	}

	public Email to(String to) {
		this.to = to;
		return this;
	}
	
	public Email cc(String cc) {
		if(this.cc == null) {
			this.cc = cc;
		} else {
			this.cc.concat(",").concat(cc);
		}
		return this;
	}
	
	public Email bcc(String bcc) {
		if(this.bcc == null) {
			this.bcc = bcc;
		} else {
			this.bcc.concat(",").concat(bcc);
		}
		return this;
	}

	public Email from(String from) {
		this.from = from;
		return this;
	}

	public Email subject(String subject) {
		this.subject = subject;
		return this;
	}
	
	public Email text(String text) {
		this.text = text;
		return this;
	}
	
	public Email build() {
		return this;
	}

	@Override
	public String toString() {
		return "Email [to=" + to + ", cc=" + cc + ", Bcc=" + bcc + ", from=" + from + ", Subject=" + subject + ", text="
				+ text + "]";
	}
	
}
