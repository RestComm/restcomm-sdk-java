package org.restcomm.connect.java.sdk.rcml.builders;

import org.restcomm.connect.java.sdk.rcml.verbs.Play;

public class PlayBuilder extends Play implements GenericBuilder<Play> {
	
	public PlayBuilder url(String length) {
		this.url = length;
		return this;
	}

	public Play build() {
		return this;
	}

}
