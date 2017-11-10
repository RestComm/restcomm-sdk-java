package org.restcomm.connect.java.sdk.rcml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Play implements GenericBuilder<Play>{
	
	@XmlValue
	protected String url;
	
	public Play() {
	}
	
	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "Play [url=" + url + "]";
	}
	
	public Play url(String length) {
		this.url = length;
		return this;
	}

	public Play build() {
		return this;
	}

}
