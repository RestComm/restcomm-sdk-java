package org.restcomm.connect.java.sdk.rcml.builders;

import org.restcomm.connect.java.sdk.rcml.verbs.Redirect;

public class RedirectBuilder extends Redirect implements GenericBuilder<Redirect> {

	public RedirectBuilder method(String method) {
		this.method = method;
		return this;
	}
	
	public Redirect build() {
		return this;
	}

}
