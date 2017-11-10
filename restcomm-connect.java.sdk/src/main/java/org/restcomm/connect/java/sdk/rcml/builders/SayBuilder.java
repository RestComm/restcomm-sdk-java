package org.restcomm.connect.java.sdk.rcml.builders;

import org.restcomm.connect.java.sdk.rcml.verbs.Say;

public class SayBuilder extends Say implements GenericBuilder<Say> {
	
	public SayBuilder voice(String voice) {
		this.voice = voice;
		return this;
	}
	public SayBuilder text(String text) {
		this.text = text;
		return this;
	}
	public SayBuilder loop(Integer loop) {
		this.loop = loop;
		return this;
	}

	public SayBuilder language(String language) {
		this.language = language;
		return this;
	}
	
	public Say build(){
		return this;
	}

}
