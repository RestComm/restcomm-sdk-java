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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Kleber Damasco kleber.damasco@hashtech.com.br
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Dial implements GenericBuilder<Dial>{

	@XmlAttribute
	protected String action;
	
	@XmlAttribute
	protected String method;

	@XmlAttribute
	protected Integer timeout;

	@XmlAttribute
	protected Integer timeLimit;

	@XmlAttribute
	protected String callerId;

	@XmlAttribute
	protected Boolean record;
	
	@XmlElement
	private Conference conference;
	
	@XmlElement
	private Sip sip;

	@XmlElement(name = "Client")
	private List<Client> clients;

	@XmlElement(name = "Number")
	private List<Number> numbers;
	
	public Dial() {
		clients = new ArrayList<Client>(0);
		numbers = new ArrayList<Number>(0);
	}
	
	public Dial action(String action) {
		this.action = action;
		return this;
	}
	public Dial method(MethodType method) {
		this.method = method.name();
		return this;
	}
	public Dial timeout(Integer timeout) {
		this.timeout = timeout;
		return this;
	}
	public Dial timeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
		return this;
	}
	public Dial callerId(String callerId) {
		this.callerId = callerId;
		return this;
	}
	public Dial record(Boolean record) {
		this.record = record;
		return this;
	}
	public Dial number(Number number) {
		this.numbers.add(number);
		return this;
	}
	public Dial client(Client client) {
		this.clients.add(client);
		return this;
	}
	public Dial conference(Conference conference) {
		this.conference = conference;
		return this;
	}
	public Dial sip(Sip sip) {
		this.sip = sip;
		return this;
	}
	public Dial build() {
		return this;
	}
	
}
