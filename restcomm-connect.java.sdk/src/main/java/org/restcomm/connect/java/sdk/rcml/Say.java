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
public class Say implements GenericBuilder<Say> {

	@XmlAttribute
	protected String voice;
	
	@XmlAttribute
	protected String language;

	@XmlAttribute
	protected Integer loop;

	@XmlValue
	protected String text;

	public Say() {
	}

	public String getVoice() {
		return voice;
	}

	public String getLanguage() {
		return language;
	}

	public Integer getLoop() {
		return loop;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "Say [voice=" + voice + ", language=" + language + ", loop=" + loop + ", text=" + text + "]";
	}
	
	public Say voice(VoiceType voice) {
		this.voice = voice.name();
		return this;
	}
	public Say text(String text) {
		this.text = text;
		return this;
	}
	public Say loop(Integer loop) {
		this.loop = loop;
		return this;
	}

	public Say language(String language) {
		this.language = language;
		return this;
	}
	
	public Say build(){
		return this;
	}
	
}
