package org.restcomm.connect.java.sdk.rcml.builders;

import org.junit.Test;

public class CreateXMLTest {
	
	@Test
	public void test(){
		try {
			ResponseBuilder response = new ResponseBuilder()
					.say(new SayBuilder().text("seila").voice("woman"))
					.pause(new PauseBuilder().length(10))
					.say(new SayBuilder().text("x").voice("man"))
					.email(new EmailBuilder().bcc("x"))
					.gather(new GatherBuilder().say("Ola").say("seja bem vindo").action("action").finishOnKey("#")) 
					.sms(new SmsBuilder().text("SMS"))
					.redirect(new RedirectBuilder().method("Post"))
					.hangup();
			
			System.out.println(response.toXML());
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}

}
