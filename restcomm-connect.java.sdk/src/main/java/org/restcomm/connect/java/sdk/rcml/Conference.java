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
public class Conference implements GenericBuilder<Conference>{
	
	@XmlAttribute
	private String name;

	@XmlAttribute
	private Boolean muted;
	
	@XmlAttribute
	private Boolean beep;
	
	@XmlAttribute
	private Boolean startConferenceOnEnter;

	@XmlAttribute
	private Boolean endConferenceOnExit;
	
	@XmlAttribute
	private String waitUrl;
	
	@XmlAttribute
	private String waitMethod;

	@XmlAttribute
	private Integer maxParticipants;
	
	@XmlValue
	private String value;

	public Conference maxParticipants(Integer maxParticipants) {
		this.maxParticipants = maxParticipants;
		return this;
	}
	public Conference waitMethod(MethodType waitMethod) {
		this.waitMethod = waitMethod.name();
		return this;
	}
	public Conference value(String value) {
		this.value = value;
		return this;
	}
	public Conference name(String name) {
		this.name = name;
		return this;
	}
	public Conference muted(Boolean muted) {
		this.muted = muted;
		return this;
	}
	public Conference beep(Boolean beep) {
		this.beep = beep;
		return this;
	}
	public Conference startConferenceOnEnter(Boolean startConferenceOnEnter) {
		this.startConferenceOnEnter = startConferenceOnEnter;
		return this;
	}
	public Conference endConferenceOnExit(Boolean endConferenceOnExit) {
		this.endConferenceOnExit = endConferenceOnExit;
		return this;
	}
	
	public Conference build() {
		return this;
	}
	@Override
	public String toString() {
		return "Conference [name=" + name + ", muted=" + muted + ", beep=" + beep + ", startConferenceOnEnter="
				+ startConferenceOnEnter + ", endConferenceOnExit=" + endConferenceOnExit + ", waitUrl=" + waitUrl
				+ ", waitMethod=" + waitMethod + ", maxParticipants=" + maxParticipants + ", value=" + value + "]";
	}
}
