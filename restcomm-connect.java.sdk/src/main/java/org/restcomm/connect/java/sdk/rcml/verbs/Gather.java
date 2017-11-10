package org.restcomm.connect.java.sdk.rcml.verbs;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Gather {
	
	@XmlAttribute
	protected String action;
	
	@XmlAttribute
	protected String method;
	
	@XmlAttribute
	protected Integer timeout;
	
	@XmlAttribute
	protected String finishOnKey;
	
	@XmlAttribute
	protected Integer numDigits;
	
	@XmlAttribute
	protected String input;
	
	@XmlAttribute
	protected String partialResultCallback;
	
	@XmlAttribute
	protected String partialResultCallbackMethod;
	
	@XmlAttribute
	protected String language;
	
	@XmlAttribute
	protected String hints;
	
	@XmlElement(name = "say")
	protected List<Say> says;
	
	@XmlElement
	protected Play play;
	
	@XmlElement
	protected Pause pause;
	
	public Gather() {
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

	public Integer getNumDigits() {
		return numDigits;
	}

	public String getInput() {
		return input;
	}

	public String getPartialResultCallback() {
		return partialResultCallback;
	}

	public String getPartialResultCallbackMethod() {
		return partialResultCallbackMethod;
	}

	public String getLanguage() {
		return language;
	}

	public String getHints() {
		return hints;
	}

	public List<Say> getSays() {
		return says;
	}

	public Play getPlay() {
		return play;
	}

	public Pause getPause() {
		return pause;
	}

	@Override
	public String toString() {
		return "Gather [action=" + action + ", method=" + method + ", timeout=" + timeout + ", finishOnKey="
				+ finishOnKey + ", numDigits=" + numDigits + ", input=" + input + ", partialResultCallback="
				+ partialResultCallback + ", partialResultCallbackMethod=" + partialResultCallbackMethod + ", language="
				+ language + ", hints=" + hints + ", says=" + says + ", play=" + play + ", pause=" + pause + "]";
	}

}
