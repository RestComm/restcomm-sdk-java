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

/**
 * @author Kleber Damasco kleber.damasco@hashtech.com.br
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Record implements GenericBuilder<Record>{
	
	@XmlAttribute
	private String action;
	
	@XmlAttribute
	private String method;
	
	@XmlAttribute
	private Integer timeout;
	
	@XmlAttribute
	private String finishOnKey;
	
	@XmlAttribute
	private Integer maxLength;
	
	@XmlAttribute
	private Boolean transcribe;
	
	@XmlAttribute
	private String transcribeCallback;
	
	@XmlAttribute
	private Boolean playBeep;
	
	@XmlAttribute
	private String media;

	public Record() {
	}

	public Record playBeep(Boolean playBeep) {
		this.playBeep = playBeep;
		return this;
	}
	public Record transcribe(Boolean transcribe) {
		this.transcribe = transcribe;
		return this;
	}
	public Record maxLength(Integer maxLength) {
		this.maxLength = maxLength;
		return this;
	}
	public Record media(String media) {
		this.media = media;
		return this;
	}
	public Record transcribeCallback(String transcribeCallback) {
		this.transcribeCallback = transcribeCallback;
		return this;
	}
	public Record finishOnKey(String finishOnKey) {
		this.finishOnKey = finishOnKey;
		return this;
	}
	public Record action(String action) {
		this.action = action;
		return this;
	}
	public Record method(MethodType method) {
		this.method = method.name();
		return this;
	}
	public Record timeout(Integer timeout) {
		this.timeout = timeout;
		return this;
	}
	public Record build() {
		return this;
	}
	@Override
	public String toString() {
		return "Record [action=" + action + ", method=" + method + ", timeout=" + timeout + ", finishOnKey="
				+ finishOnKey + ", maxLength=" + maxLength + ", transcribe=" + transcribe + ", transcribeCallback="
				+ transcribeCallback + ", playBeep=" + playBeep + ", media=" + media + "]";
	}
}