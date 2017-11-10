package org.restcomm.connect.java.sdk.rcml.verbs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Sms {

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
	
}
