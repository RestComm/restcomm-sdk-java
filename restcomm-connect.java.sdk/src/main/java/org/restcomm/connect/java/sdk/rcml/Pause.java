package org.restcomm.connect.java.sdk.rcml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Pause implements GenericBuilder<Pause>{
	
	@XmlAttribute
	protected Integer length;
	
	public Pause() {
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Pause [length=" + length + "]";
	}
	
	public Pause length(Integer length) {
		this.length = length;
		return this;
	}

	public Pause build() {
		return this;
	}
	
}
