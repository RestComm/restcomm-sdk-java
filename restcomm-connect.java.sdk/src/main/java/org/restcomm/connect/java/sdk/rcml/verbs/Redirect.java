package org.restcomm.connect.java.sdk.rcml.verbs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Redirect {
	
	@XmlAttribute
	protected String method;
	
	public Redirect() {
	}

	public String getMethod() {
		return method;
	}

	@Override
	public String toString() {
		return "Redirect [method=" + method + "]";
	}

}
