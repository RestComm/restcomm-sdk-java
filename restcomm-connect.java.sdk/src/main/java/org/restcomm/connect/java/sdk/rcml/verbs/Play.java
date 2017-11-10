package org.restcomm.connect.java.sdk.rcml.verbs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Play {
	
	@XmlValue
	protected String url;
	
	public Play() {
	}
	
	public String getUrl() {
		return url;
	}

}
