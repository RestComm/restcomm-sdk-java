package org.restcomm.connect.java.sdk.rcml.builders;

import org.restcomm.rcml.verbs.Email;

public class EmailBuilder extends Email implements GenericBuilder<Email> {
	
	public EmailBuilder to(String to) {
		this.to = to;
		return this;
	}
	
	public EmailBuilder cc(String cc) {
		this.cc = cc;
		return this;
	}
	
	public EmailBuilder bcc(String bcc) {
		this.bcc = bcc;
		return this;
	}

	public EmailBuilder from(String from) {
		this.from = from;
		return this;
	}

	public EmailBuilder subject(String subject) {
		this.subject = subject;
		return this;
	}
	
	public EmailBuilder text(String text) {
		this.text = text;
		return this;
	}
	
	public Email build() {
		return this;
	}

}
