package org.restcomm.connect.java.sdk.rcml.builders;

import org.junit.Test;
import org.restcomm.connect.java.sdk.rcml.Email;
import org.restcomm.connect.java.sdk.rcml.Gather;
import org.restcomm.connect.java.sdk.rcml.Pause;
import org.restcomm.connect.java.sdk.rcml.Redirect;
import org.restcomm.connect.java.sdk.rcml.Response;
import org.restcomm.connect.java.sdk.rcml.Say;
import org.restcomm.connect.java.sdk.rcml.Sms;

public class CreateXMLTest {
	
	@Test
	public void test(){
		try {
			Response response = new Response().say(new Say().text("oi").voice("man"))
			.pause(new Pause().length(10))
			.say(new Say().language("bp").text("teste"))
			.email(new Email().text("ola email"))
			.gather(new Gather().say("Ola").say("seja bem vindo").action("action").finishOnKey("#"))
			.sms(new Sms().text("SMS"))
			.redirect(new Redirect().method("Post"))
			.hangup().build();
			System.out.println(response.toXML());
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}

}
