package org.restcomm.connect.java.sdk.rcml.builders;

import org.restcomm.connect.java.sdk.rcml.verbs.Pause;

public class PauseBuilder extends Pause implements GenericBuilder<Pause>{
	
	public PauseBuilder length(Integer length) {
		this.length = length;
		return this;
	}

	public Pause build() {
		return this;
	}

}
