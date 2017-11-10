package org.restcomm.connect.java.sdk.rcml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

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
