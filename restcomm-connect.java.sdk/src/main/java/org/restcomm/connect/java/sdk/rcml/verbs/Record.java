package org.restcomm.connect.java.sdk.rcml.verbs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Record {
	
	@XmlAttribute
	private String action;
	
	@XmlAttribute
	private String method;
	
	@XmlAttribute
	private Integer timeout;
	
	@XmlAttribute
	private String finishOnKey;
	
	@XmlAttribute
	private Integer maxLength;
	
	@XmlAttribute
	private Boolean transcribe;
	
	@XmlAttribute
	private String transcribeCallback;
	
	@XmlAttribute
	private Boolean playBeep;
	
	@XmlAttribute
	private String media;

	public Record() {
	}

	public String getAction() {
		return action;
	}

	public String getMethod() {
		return method;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public String getFinishOnKey() {
		return finishOnKey;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public Boolean getTranscribe() {
		return transcribe;
	}

	public String getTranscribeCallback() {
		return transcribeCallback;
	}

	public Boolean getPlayBeep() {
		return playBeep;
	}

	public String getMedia() {
		return media;
	}

	@Override
	public String toString() {
		return "Record [action=" + action + ", method=" + method + ", timeout=" + timeout + ", finishOnKey="
				+ finishOnKey + ", maxLength=" + maxLength + ", transcribe=" + transcribe + ", transcribeCallback="
				+ transcribeCallback + ", playBeep=" + playBeep + ", media=" + media + "]";
	}
	
}