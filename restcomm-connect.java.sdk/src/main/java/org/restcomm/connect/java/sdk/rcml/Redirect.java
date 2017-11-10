package org.restcomm.connect.java.sdk.rcml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Redirect implements GenericBuilder<Redirect>{
	
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
	
	public Redirect method(String method) {
		this.method = method;
		return this;
	}
	
	public Redirect build() {
		return this;
	}

}
