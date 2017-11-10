package org.restcomm.connect.java.sdk.rcml.builders;

import java.util.ArrayList;

import org.restcomm.connect.java.sdk.rcml.verbs.Gather;
import org.restcomm.connect.java.sdk.rcml.verbs.Pause;
import org.restcomm.connect.java.sdk.rcml.verbs.Play;
import org.restcomm.connect.java.sdk.rcml.verbs.Say;

public class GatherBuilder extends Gather implements GenericBuilder<Gather> {
	
	public GatherBuilder action(String action) {
		this.action = action;
		return this;
	}
	public GatherBuilder method(String method) {
		this.method = method;
		return this;
	}
	public GatherBuilder timeout(Integer timeout) {
		this.timeout = timeout;
		return this;
	}
	public GatherBuilder finishOnKey(String finishOnKey) {
		this.finishOnKey = finishOnKey;
		return this;
	}
	public GatherBuilder numDigits(Integer numDigits) {
		this.numDigits = numDigits;
		return this;
	}
	public GatherBuilder input(String input) {
		this.input = input;
		return this;
	}
	public GatherBuilder partialResultCallback(String partialResultCallback) {
		this.partialResultCallback = partialResultCallback;
		return this;
	}
	public GatherBuilder partialResultCallbackMethod(String partialResultCallbackMethod) {
		this.partialResultCallbackMethod = partialResultCallbackMethod;
		return this;
	}
	public GatherBuilder language(String language) {
		this.language = language;
		return this;
	}
	public GatherBuilder hints(String hints) {
		this.hints = hints;
		return this;
	}
	public GatherBuilder say(Say say) {
		if(this.says == null) new ArrayList<Say>(0);
		this.says.add(say);
		return this;
	}
	public GatherBuilder say(String sayText) {
		if(this.says == null) says = new ArrayList<Say>(0);
		this.says.add(new SayBuilder().text(sayText).build());
		return this;
	}
	public GatherBuilder play(Play play) {
		this.play = play;
		return this;
	}
	public GatherBuilder pause(Pause pause) {
		this.pause = pause;
		return this;
	}
	
	public Gather build() {
		return this;
	}

}
