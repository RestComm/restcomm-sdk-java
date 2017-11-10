package org.restcomm.connect.java.sdk.rcml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Gather implements GenericBuilder<Gather>{
	
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
	
	public Gather action(String action) {
		this.action = action;
		return this;
	}
	public Gather method(String method) {
		this.method = method;
		return this;
	}
	public Gather timeout(Integer timeout) {
		this.timeout = timeout;
		return this;
	}
	public Gather finishOnKey(String finishOnKey) {
		this.finishOnKey = finishOnKey;
		return this;
	}
	public Gather numDigits(Integer numDigits) {
		this.numDigits = numDigits;
		return this;
	}
	public Gather input(String input) {
		this.input = input;
		return this;
	}
	public Gather partialResultCallback(String partialResultCallback) {
		this.partialResultCallback = partialResultCallback;
		return this;
	}
	public Gather partialResultCallbackMethod(String partialResultCallbackMethod) {
		this.partialResultCallbackMethod = partialResultCallbackMethod;
		return this;
	}
	public Gather language(String language) {
		this.language = language;
		return this;
	}
	public Gather hints(String hints) {
		this.hints = hints;
		return this;
	}
	public Gather say(Say say) {
		if(this.says == null) new ArrayList<Say>(0);
		this.says.add(say);
		return this;
	}
	public Gather say(String sayText) {
		if(this.says == null) says = new ArrayList<Say>(0);
		this.says.add(new Say().text(sayText).build());
		return this;
	}
	public Gather play(Play play) {
		this.play = play;
		return this;
	}
	public Gather pause(Pause pause) {
		this.pause = pause;
		return this;
	}
	
	public Gather build() {
		return this;
	}
	
	

}
