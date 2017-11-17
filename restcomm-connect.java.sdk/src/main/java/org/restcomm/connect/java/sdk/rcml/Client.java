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
public class Client implements GenericBuilder<Client>{
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private String url;

	@XmlAttribute
	private String method;

	@XmlAttribute
	private String statusCallbackEvent;

	@XmlAttribute
	private String statusCallback;

	@XmlAttribute
	private String statusCallbackMethod;

	@XmlValue
	private String value;
	
	public Client name(String name) {
		this.name = name;
		return this;
	}
	public Client url(String url) {
		this.url = url;
		return this;
	}
	public Client method(MethodType method) {
		this.method = method.name();
		return this;
	}
	public Client statusCallbackEvent(StatusCallbackType statusCallbackEvent) {
		this.statusCallbackEvent = statusCallbackEvent.getName();
		return this;
	}
	public Client statusCallback(String statusCallback) {
		this.statusCallback = statusCallback;
		return this;
	}
	public Client statusCallbackMethod(MethodType method) {
		this.statusCallbackMethod = method.name();
		return this;
	}
	public Client value(String value) {
		this.value = value;
		return this;
	}
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", url=" + url + ", method=" + method + ", statusCallbackEvent="
				+ statusCallbackEvent + ", statusCallback=" + statusCallback + ", statusCallbackMethod="
				+ statusCallbackMethod + ", value=" + value + "]";
	}
	public Client build() {
		return this;
	}
}
