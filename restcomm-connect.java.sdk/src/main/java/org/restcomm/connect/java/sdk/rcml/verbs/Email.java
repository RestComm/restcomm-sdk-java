package org.restcomm.connect.java.sdk.rcml.verbs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Email {

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

	public String getTo() {
		return to;
	}

	public String getCc() {
		return cc;
	}

	public String getBcc() {
		return bcc;
	}

	public String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "Email [to=" + to + ", cc=" + cc + ", Bcc=" + bcc + ", from=" + from + ", Subject=" + subject + ", text="
				+ text + "]";
	}
	
}
