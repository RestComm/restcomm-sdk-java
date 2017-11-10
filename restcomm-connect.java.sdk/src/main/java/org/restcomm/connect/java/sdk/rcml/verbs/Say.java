package org.restcomm.connect.java.sdk.rcml.verbs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Say {

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
	
}
