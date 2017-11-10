package org.restcomm.connect.java.sdk.rcml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Record implements GenericBuilder<Record>{
	
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
	
	public Record playBeep(Boolean playBeep) {
		this.playBeep = playBeep;
		return this;
	}
	public Record transcribe(Boolean transcribe) {
		this.transcribe = transcribe;
		return this;
	}
	public Record maxLength(Integer maxLength) {
		this.maxLength = maxLength;
		return this;
	}
	public Record media(String media) {
		this.media = media;
		return this;
	}
	public Record transcribeCallback(String transcribeCallback) {
		this.transcribeCallback = transcribeCallback;
		return this;
	}
	public Record finishOnKey(String finishOnKey) {
		this.finishOnKey = finishOnKey;
		return this;
	}
	public Record action(String action) {
		this.action = action;
		return this;
	}
	public Record method(String method) {
		this.method = method;
		return this;
	}
	public Record timeout(Integer timeout) {
		this.timeout = timeout;
		return this;
	}
	public Record build() {
		return this;
	}
}