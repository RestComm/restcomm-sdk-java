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
public class Gather implements GenericBuilder<Gather>{

	@XmlAttribute
	private String action;

	@XmlAttribute
	private String method;

	@XmlAttribute
	private Integer timeout;

	@XmlAttribute
	private String finishOnKey;

	@XmlAttribute
	private Integer numDigits;

	@XmlAttribute
	private String input;

	@XmlAttribute
	private String partialResultCallback;

	@XmlAttribute
	private String partialResultCallbackMethod;

	@XmlAttribute
	private String language;

	@XmlAttribute
	private String hints;

	@XmlElement(name = "Say")
	private List<Say> says;

	@XmlElement(name = "Play")
	private Play play;

	@XmlElement(name = "Pause")
	private Pause pause;

	public Gather() {
		this.says = new ArrayList<Say>();
	}

	public Gather action(String action) {
		this.action = action;
		return this;
	}
	public Gather method(MethodType methodType) {
		this.method = methodType.name();
		return this;
	}
	public Gather timeout(Integer timeout) {
		this.timeout = timeout;
		return this;
	}
	public Gather finishOnKey(String finishOnKey) {
		this.finishOnKey = finishOnKey;
		return this;
	}
	public Gather numDigits(Integer numDigits) {
		this.numDigits = numDigits;
		return this;
	}
	public Gather input(InputType input) {
		this.input = input.getName();
		return this;
	}
	public Gather partialResultCallback(String partialResultCallback) {
		this.partialResultCallback = partialResultCallback;
		return this;
	}
	public Gather partialResultCallbackMethod(MethodType methodType) {
		this.partialResultCallbackMethod = methodType.name();
		return this;
	}
	public Gather language(LanguageType language) {
		this.language = language.getName();
		return this;
	}
	public Gather hints(String hints) {
		this.hints = hints;
		return this;
	}
	public Gather say(Say say) {
		this.says.add(say);
		return this;
	}
	public Gather say(String sayText) {
		this.says.add(new Say().text(sayText).build());
		return this;
	}
	public Gather play(Play play) {
		this.play = play;
		return this;
	}
	public Gather pause(Pause pause) {
		this.pause = pause;
		return this;
	}

	public Gather build() {
		return this;
	}
	
	@Override
	public String toString() {
		return "Gather [action=" + action + ", method=" + method + ", timeout=" + timeout + ", finishOnKey="
				+ finishOnKey + ", numDigits=" + numDigits + ", input=" + input + ", partialResultCallback="
				+ partialResultCallback + ", partialResultCallbackMethod=" + partialResultCallbackMethod + ", language="
				+ language + ", hints=" + hints + ", says=" + says + ", play=" + play + ", pause=" + pause + "]";
	}
}
