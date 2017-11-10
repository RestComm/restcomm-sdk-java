package org.restcomm.connect.java.sdk.rcml.builders;

import org.restcomm.connect.java.sdk.rcml.verbs.Sms;

public class SmsBuilder extends Sms implements GenericBuilder<Sms> {
	
	public SmsBuilder to(String to) {
		this.to = to;
		return this;
	}
	
	public SmsBuilder from(String from) {
		this.from = from;
		return this;
	}
	
	public SmsBuilder action(String action) {
		this.action = action;
		return this;
	}

	public SmsBuilder method(String method) {
		this.method = method;
		return this;
	}

	public SmsBuilder statusCallback(String statusCallback) {
		this.statusCallback = statusCallback;
		return this;
	}
	
	public SmsBuilder text(String text) {
		this.text = text;
		return this;
	}
	
	public Sms build() {
		return this;
	}
}
